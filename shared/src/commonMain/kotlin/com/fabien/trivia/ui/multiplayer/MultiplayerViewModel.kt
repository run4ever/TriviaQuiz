package com.fabien.trivia.ui.multiplayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.AuthRepository
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.QuestionRepository
import com.fabien.trivia.data.RemoteQuestionRepository
import com.fabien.trivia.data.UserProfileRepository
import com.fabien.trivia.data.multiplayer.GamePlayer
import com.fabien.trivia.data.multiplayer.GameRoom
import com.fabien.trivia.data.multiplayer.GameRoomRepository
import com.fabien.trivia.data.multiplayer.ScoringMode
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class MpPhase { ENTRY, CREATE, JOIN, LOBBY }

data class MultiplayerUiState(
    val phase: MpPhase = MpPhase.ENTRY,
    val pseudo: String = "",
    val isHost: Boolean = false,
    val room: GameRoom? = null,
    val players: List<GamePlayer> = emptyList(),
    val isBusy: Boolean = false,
    val error: String? = null
)

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

    init {
        viewModelScope.launch {
            _state.value = _state.value.copy(pseudo = loadDefaultPseudo())
        }
    }

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
    }

    fun startGame() {
        val code = roomCode ?: return
        launchBusy { rooms.startGame(code) }
    }

    fun leaveGame() {
        val code = roomCode
        val uid = myId
        val isHost = _state.value.isHost
        roomJob?.cancel()
        playersJob?.cancel()
        viewModelScope.launch {
            if (code != null && uid != null) runCatching { rooms.leaveRoom(code, uid, isHost) }
            resetToEntry()
        }
    }

    private fun resetToEntry() {
        roomJob?.cancel()
        playersJob?.cancel()
        roomCode = null
        myId = null
        _state.value = _state.value.copy(
            phase = MpPhase.ENTRY,
            isHost = false,
            room = null,
            players = emptyList()
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
        roomJob?.cancel()
        playersJob?.cancel()
    }
}
