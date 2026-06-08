package com.fabien.trivia.ui.multiplayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.AuthRepository
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.Question
import com.fabien.trivia.data.QuestionRepository
import com.fabien.trivia.data.RemoteQuestionRepository
import com.fabien.trivia.data.UserProfileRepository
import com.fabien.trivia.data.multiplayer.GamePlayer
import com.fabien.trivia.data.multiplayer.GameRoom
import com.fabien.trivia.data.multiplayer.GameRoomRepository
import com.fabien.trivia.data.multiplayer.GameStatus
import com.fabien.trivia.data.multiplayer.ScoringMode
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlin.math.roundToInt

enum class MpPhase { ENTRY, CREATE, JOIN, LOBBY }

enum class RoundPhase { ANSWERING, REVEAL }

/** Vue dérivée de la question en cours, recalculée au fil du minuteur. */
data class RoundInfo(
    val question: Question,
    val index: Int,
    val total: Int,
    val phase: RoundPhase,
    val remainingMs: Long,
    val myChoice: Int?
)

data class MultiplayerUiState(
    val phase: MpPhase = MpPhase.ENTRY,
    val pseudo: String = "",
    val isHost: Boolean = false,
    val room: GameRoom? = null,
    val players: List<GamePlayer> = emptyList(),
    val round: RoundInfo? = null,
    val isBusy: Boolean = false,
    val error: String? = null
)

private const val QUESTION_DURATION_MS = 20_000L
private const val REVEAL_DURATION_MS = 5_000L

/**
 * Pilote le flux du salon multijoueur : accueil (créer/rejoindre), config hôte, salon temps réel.
 * Garantit une identité Firebase (anonyme si l'utilisateur n'a pas de compte) avant toute écriture.
 * Le déroulé de la partie (statut PLAYING) sera géré à l'étape 2.
 */
class MultiplayerViewModel(
    private val rooms: GameRoomRepository = GameRoomRepository(),
    private val auth: AuthRepository = AuthRepository(),
    private val profiles: UserProfileRepository = UserProfileRepository(),
    private val remoteQuestions: RemoteQuestionRepository = RemoteQuestionRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(MultiplayerUiState())
    val state: StateFlow<MultiplayerUiState> = _state.asStateFlow()

    private var myId: String? = null
    private var roomCode: String? = null
    private var roomJob: Job? = null
    private var playersJob: Job? = null
    private var hostJob: Job? = null
    private var tickerJob: Job? = null

    /** Map id → Question pour résoudre les questionIds de la partie (mêmes questions pour tous). */
    private var questionById: Map<String, Question> = QuestionRepository.questions.associateBy { it.id }
    private var lastSeenIndex: Int = -1
    private var myChoice: Int? = null

    init {
        viewModelScope.launch {
            _state.value = _state.value.copy(pseudo = loadDefaultPseudo())
        }
        loadQuestions()
    }

    private fun loadQuestions() {
        viewModelScope.launch {
            val pool = runCatching { remoteQuestions.fetchAll() }.getOrNull()?.takeIf { it.isNotEmpty() }
                ?: QuestionRepository.questions
            questionById = pool.associateBy { it.id }
        }
    }

    private fun nowMs(): Long = Clock.System.now().toEpochMilliseconds()

    private suspend fun loadDefaultPseudo(): String {
        val user = auth.currentUser
        if (user != null && !user.isAnonymous) {
            runCatching { profiles.getPseudo(user.uid) }.getOrNull()?.let { return it }
            user.email?.substringBefore("@")?.let { return it }
        }
        return ""
    }

    /** Garantit une identité Firebase (anonyme si nécessaire) et renvoie l'UID. */
    private suspend fun ensureUid(): String {
        auth.currentUser?.let { return it.uid }
        auth.signInAnonymously()
        return auth.currentUser?.uid ?: error("Authentification impossible")
    }

    fun setPseudo(value: String) {
        _state.value = _state.value.copy(pseudo = value)
    }

    fun goToCreate() {
        _state.value = _state.value.copy(phase = MpPhase.CREATE, error = null)
    }

    fun goToJoin() {
        _state.value = _state.value.copy(phase = MpPhase.JOIN, error = null)
    }

    fun backToEntry() {
        _state.value = _state.value.copy(phase = MpPhase.ENTRY, error = null)
    }

    fun createGame(scoringMode: ScoringMode, questionCount: Int?, category: Category?) {
        val pseudo = _state.value.pseudo.trim()
        if (pseudo.isBlank()) { setError("Choisis un pseudo"); return }
        launchBusy {
            val uid = ensureUid()
            val questionIds = buildQuestionIds(category, questionCount)
            val code = rooms.generateUniqueCode()
            rooms.createRoom(code, uid, scoringMode, questionCount, category, questionIds, pseudo)
            enterRoom(code, uid, isHost = true)
        }
    }

    fun joinGame(rawCode: String) {
        val pseudo = _state.value.pseudo.trim()
        if (pseudo.isBlank()) { setError("Choisis un pseudo"); return }
        val code = rawCode.trim().uppercase()
        if (code.length != 4) { setError("Le code fait 4 caractères"); return }
        launchBusy {
            val uid = ensureUid()
            if (!rooms.roomExists(code)) { setError("Partie introuvable"); return@launchBusy }
            rooms.joinRoom(code, uid, pseudo)
            enterRoom(code, uid, isHost = false)
        }
    }

    /** Construit la liste ordonnée d'IDs de questions (remote, fallback bundlé), filtrée + tronquée. */
    private suspend fun buildQuestionIds(category: Category?, count: Int?): List<String> {
        val pool = runCatching { remoteQuestions.fetchAll() }.getOrNull()?.takeIf { it.isNotEmpty() }
            ?: QuestionRepository.questions
        val filtered = if (category != null) pool.filter { it.category == category } else pool
        val ids = filtered.shuffled().map { it.id }
        return if (count != null) ids.take(count) else ids
    }

    private fun enterRoom(code: String, uid: String, isHost: Boolean) {
        myId = uid
        roomCode = code
        _state.value = _state.value.copy(phase = MpPhase.LOBBY, isHost = isHost, error = null)
        roomJob?.cancel()
        playersJob?.cancel()
        roomJob = viewModelScope.launch {
            rooms.observeRoom(code).collect { room ->
                if (room == null) resetToEntry() // partie supprimée (hôte parti)
                else _state.value = _state.value.copy(room = room)
            }
        }
        playersJob = viewModelScope.launch {
            rooms.observePlayers(code).collect { players ->
                _state.value = _state.value.copy(players = players)
            }
        }
        startTicker()
    }

    /** Recalcule l'état de la question courante toutes les 250 ms (minuteur + phase). */
    private fun startTicker() {
        tickerJob?.cancel()
        tickerJob = viewModelScope.launch {
            while (true) {
                recomputeRound()
                delay(250)
            }
        }
    }

    private fun recomputeRound() {
        val room = _state.value.room
        if (room == null || room.status != GameStatus.PLAYING) {
            if (_state.value.round != null) _state.value = _state.value.copy(round = null)
            // Hors partie (salon / résultats) : on repart d'une ardoise propre pour la prochaine manche.
            lastSeenIndex = -1
            myChoice = null
            return
        }
        val total = room.questionIds.size
        val question = room.questionIds.getOrNull(room.currentIndex)?.let { questionById[it] }
        if (question == null) {
            if (_state.value.round != null) _state.value = _state.value.copy(round = null)
            return
        }
        // Changement de question → on réinitialise mon choix.
        if (room.currentIndex != lastSeenIndex) {
            lastSeenIndex = room.currentIndex
            myChoice = null
        }
        val elapsed = nowMs() - room.currentStartedAt
        // Révélation si l'hôte l'a déclenchée (tous ont répondu) OU si le temps est écoulé.
        val reveal = room.revealStartedAt != 0L || elapsed >= QUESTION_DURATION_MS
        val phase = if (reveal) RoundPhase.REVEAL else RoundPhase.ANSWERING
        val remainingMs = (QUESTION_DURATION_MS - elapsed).coerceAtLeast(0)
        _state.value = _state.value.copy(
            round = RoundInfo(question, room.currentIndex, total, phase, remainingMs, myChoice)
        )
    }

    /** L'hôte démarre la partie et pilote l'avancement (une question toutes les durée+révélation). */
    fun startGame() {
        val code = roomCode ?: return
        val room = _state.value.room ?: return
        if (!_state.value.isHost) return
        val total = room.questionIds.size
        if (total == 0) { setError("Aucune question disponible"); return }
        hostJob?.cancel()
        hostJob = viewModelScope.launch {
            runCatching { rooms.startGame(code, nowMs()) }
            var index = 0
            while (index < total) {
                // Phase réponse : on attend que TOUS aient répondu, ou la fin du minuteur.
                val deadline = nowMs() + QUESTION_DURATION_MS
                while (nowMs() < deadline && !allAnsweredFor(index)) {
                    delay(200)
                }
                runCatching { rooms.setReveal(code, nowMs()) }
                // Phase révélation.
                delay(REVEAL_DURATION_MS)
                index++
                if (index >= total) {
                    runCatching { rooms.finishGame(code) }
                } else {
                    runCatching { rooms.advance(code, index, nowMs()) }
                }
            }
        }
    }

    private fun allAnsweredFor(index: Int): Boolean {
        val players = _state.value.players
        return players.isNotEmpty() && players.all { it.answeredIndex == index }
    }

    /** L'hôte termine la partie avant la fin (mode partie ouverte ou arrêt anticipé). */
    fun endGame() {
        val code = roomCode ?: return
        hostJob?.cancel()
        viewModelScope.launch { runCatching { rooms.finishGame(code) } }
    }

    /** L'hôte relance une partie avec les mêmes joueurs : scores remis à 0, nouvelles questions, retour salon. */
    fun replay() {
        val code = roomCode ?: return
        val room = _state.value.room ?: return
        if (!_state.value.isHost) return
        hostJob?.cancel()
        launchBusy {
            val questionIds = buildQuestionIds(room.category, room.questionCount)
            rooms.resetForReplay(code, questionIds)
        }
    }

    /** Le joueur courant répond à la question en cours (une seule fois, pendant la phase ANSWERING). */
    fun submitAnswer(choice: Int) {
        val round = _state.value.round ?: return
        if (round.phase != RoundPhase.ANSWERING || round.myChoice != null) return
        val code = roomCode ?: return
        val uid = myId ?: return
        val mode = _state.value.room?.scoringMode ?: return
        val correct = round.question.correctIndex == choice
        val points = computePoints(correct, round.remainingMs, mode)
        myChoice = choice
        recomputeRound() // reflète le choix immédiatement
        val myScore = _state.value.players.find { it.id == uid }?.score ?: 0
        viewModelScope.launch {
            runCatching { rooms.submitAnswer(code, uid, myScore + points, round.index, choice, points) }
        }
    }

    private fun computePoints(correct: Boolean, remainingMs: Long, mode: ScoringMode): Int {
        if (!correct) return 0
        return when (mode) {
            ScoringMode.SIMPLE -> 1
            // Bonne réponse : 500 pts garantis + jusqu'à 500 selon la rapidité (max 1000).
            ScoringMode.RAPIDITE -> (500 + 500 * (remainingMs.toDouble() / QUESTION_DURATION_MS)).roundToInt()
        }
    }

    fun leaveGame() {
        val code = roomCode
        val uid = myId
        val isHost = _state.value.isHost
        cancelRoomJobs()
        viewModelScope.launch {
            if (code != null && uid != null) runCatching { rooms.leaveRoom(code, uid, isHost) }
            resetToEntry()
        }
    }

    private fun cancelRoomJobs() {
        roomJob?.cancel()
        playersJob?.cancel()
        hostJob?.cancel()
        tickerJob?.cancel()
    }

    private fun resetToEntry() {
        cancelRoomJobs()
        roomCode = null
        myId = null
        lastSeenIndex = -1
        myChoice = null
        _state.value = _state.value.copy(
            phase = MpPhase.ENTRY,
            isHost = false,
            room = null,
            players = emptyList(),
            round = null
        )
    }

    private fun setError(message: String) {
        _state.value = _state.value.copy(error = message, isBusy = false)
    }

    private fun launchBusy(block: suspend () -> Unit) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isBusy = true, error = null)
            try {
                block()
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message ?: "Une erreur est survenue")
            } finally {
                _state.value = _state.value.copy(isBusy = false)
            }
        }
    }

    override fun onCleared() {
        cancelRoomJobs()
    }
}
