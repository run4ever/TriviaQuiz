package com.fabien.trivia.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.DatabaseDriverFactory
import com.fabien.trivia.data.PlayerRatingSync
import com.fabien.trivia.data.PlayerRatings
import com.fabien.trivia.data.Question
import com.fabien.trivia.data.QuestionRepository
import com.fabien.trivia.data.QuestionStatsRepository
import com.fabien.trivia.data.RatingsRepository
import com.fabien.trivia.data.RemoteQuestionRepository
import com.fabien.trivia.data.StreakRepository
import com.fabien.trivia.data.TriviaDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.pow
import kotlin.math.roundToInt

enum class GamePhase { HOME, CATEGORY_SELECT, PLAYING }

data class GameState(
    val phase: GamePhase = GamePhase.HOME,
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedAnswerIndex: Int? = null,
    val answerConfirmed: Boolean = false,
    val playerRating: Int = 750,
    val categoryRatings: Map<Category, Int> = Category.entries.associateWith { 750 },
    val lastRatingDelta: Int = 0,
    val selectedCategory: Category? = null,
    val streak: Int = 0,
    /** Bonnes réponses consécutives (solo), PERSISTÉE : continue d'un jour/session à l'autre, remise à 0 sur erreur. ≠ série de jours [streak]. */
    val correctStreak: Int = 0,
    /** Meilleure suite de bonnes réponses (record persistant, pour le futur écran de stats). */
    val bestCorrectStreak: Int = 0
) {
    val displayedRating: Int
        get() = if (selectedCategory != null) categoryRatings[selectedCategory] ?: 750 else playerRating
}

class GameViewModel(driverFactory: DatabaseDriverFactory) : ViewModel() {
    private val database = TriviaDatabase(driverFactory.createDriver())
    private val ratingsRepository = RatingsRepository(database)
    private val questionStatsRepository = QuestionStatsRepository(database)
    private val streakRepository = StreakRepository(database)
    private val ratingSync = PlayerRatingSync()
    private val remoteQuestions = RemoteQuestionRepository()
    private val _state = MutableStateFlow(GameState(
        playerRating = ratingsRepository.getPlayerRating(),
        categoryRatings = ratingsRepository.getAllCategoryRatings(),
        streak = streakRepository.currentStreak(),
        correctStreak = streakRepository.correctStreak(null),
        bestCorrectStreak = streakRepository.bestCorrectStreak(null)
    ))
    val state: StateFlow<GameState> = _state.asStateFlow()

    /**
     * Banque de questions effective. Démarre sur le set bundlé (disponible instantanément,
     * offline-first) puis est remplacée par les questions distantes dès qu'elles sont récupérées.
     */
    private var questionPool: List<Question> = QuestionRepository.questions

    /** UID du compte connecté, null si déconnecté. Détermine si on pousse vers Firestore. */
    private var currentUid: String? = null

    init {
        refreshQuestions()
    }

    /** Récupère les questions distantes ; en cas d'échec (hors-ligne), on garde le set bundlé. */
    private fun refreshQuestions() {
        viewModelScope.launch {
            try {
                val remote = remoteQuestions.fetchAll()
                if (remote.isNotEmpty()) questionPool = remote
            } catch (_: Exception) {
                // Hors-ligne / collection absente : fallback sur le set bundlé déjà en place.
            }
        }
    }

    private fun questionsFor(category: Category?): List<Question> =
        if (category != null) questionPool.filter { it.category == category } else questionPool

    /**
     * Appelé quand l'utilisateur connecté change (connexion / déconnexion / changement de compte).
     * - connexion avec un doc cloud existant → le cloud fait foi : on écrase le rating local.
     * - connexion sans doc cloud → on sème le cloud depuis le local.
     * - déconnexion (uid null) → on garde le local tel quel, plus de push.
     * Toute erreur réseau est ignorée : le local reste autoritaire et Firestore resynchronisera.
     */
    fun onUserChanged(uid: String?) {
        currentUid = uid
        if (uid == null) return
        viewModelScope.launch {
            try {
                val cloud = ratingSync.fetch(uid)
                if (cloud != null) {
                    applyCloudRatings(cloud)
                } else {
                    ratingSync.push(uid, currentLocalRatings())
                }
            } catch (_: Exception) {
                // Hors-ligne / erreur : le local reste source de vérité ; la synchro reprendra plus tard.
            }
        }
    }

    private fun currentLocalRatings() = PlayerRatings(
        global = _state.value.playerRating,
        categories = _state.value.categoryRatings
    )

    private fun applyCloudRatings(cloud: PlayerRatings) {
        ratingsRepository.savePlayerRating(cloud.global)
        cloud.categories.forEach { (category, rating) -> ratingsRepository.saveCategoryRating(category, rating) }
        _state.value = _state.value.copy(
            playerRating = cloud.global,
            categoryRatings = cloud.categories
        )
    }

    /** Pousse l'état local courant vers Firestore (fire-and-forget) si connecté. */
    private fun pushRatings() {
        val uid = currentUid ?: return
        viewModelScope.launch {
            try {
                ratingSync.push(uid, currentLocalRatings())
            } catch (_: Exception) {
                // Firestore rejoue l'écriture à la reconnexion.
            }
        }
    }

    fun goToCategorySelect() {
        _state.value = _state.value.copy(phase = GamePhase.CATEGORY_SELECT)
    }

    fun startGame(category: Category? = null) {
        val questions = questionsFor(category).shuffled()
        // Jouer aujourd'hui (re)alimente la série quotidienne.
        val streak = streakRepository.registerPlay()
        _state.value = GameState(
            phase = GamePhase.PLAYING,
            questions = questions,
            selectedCategory = category,
            playerRating = _state.value.playerRating,
            categoryRatings = _state.value.categoryRatings,
            streak = streak,
            // Suite de bonnes réponses CONTEXTUELLE (catégorie choisie, ou globale en « toutes catégories »),
            // persistée (ne repart pas à 0 à chaque partie).
            correctStreak = streakRepository.correctStreak(category),
            bestCorrectStreak = streakRepository.bestCorrectStreak(category)
        )
    }

    /**
     * Enregistre une partie jouée aujourd'hui pour la série (idempotent dans la journée).
     * Appelé aussi au démarrage d'une partie multijoueur (cf. `App.kt`), pas seulement en solo.
     */
    fun registerPlay() {
        _state.value = _state.value.copy(streak = streakRepository.registerPlay())
    }

    fun selectAnswer(index: Int) {
        val current = _state.value
        if (current.answerConfirmed) return
        val question = current.questions[current.currentIndex]
        val isCorrect = question.correctIndex == index

        // État persisté de la question : rating dynamique (graine du code si jamais jouée) + historique anti-grind.
        val stats = questionStatsRepository.getStats(question.id)
        val questionRating = stats?.rating?.toInt() ?: question.rating
        val priorCorrect = stats?.timesCorrect?.toInt() ?: 0

        // Anti-grind : le gain est réduit si la question a déjà été réussie auparavant.
        // La pénalité (mauvaise réponse) reste pleine à chaque fois.
        val gainFactor = if (isCorrect) repeatedCorrectFactor(priorCorrect) else 1.0

        val categoryRating = current.categoryRatings[question.category] ?: 750
        val categoryDelta = scaleGain(eloRatingDelta(categoryRating, questionRating, isCorrect), gainFactor)
        val newCategoryRating = (categoryRating + categoryDelta).coerceAtLeast(100)
        val newCategoryRatings = current.categoryRatings + (question.category to newCategoryRating)

        // Suite de bonnes réponses (persistée, miroir des ratings) : on met à jour la suite de la
        // catégorie de la question, et la globale uniquement en mode « toutes catégories ».
        val allCategories = current.selectedCategory == null
        streakRepository.recordAnswer(question.category, isCorrect, includeGlobal = allCategories)
        // Suite contextuelle affichée dans l'en-tête : catégorie en mode catégorie, sinon globale.
        val newCorrectStreak = streakRepository.correctStreak(current.selectedCategory)
        val newBestCorrectStreak = streakRepository.bestCorrectStreak(current.selectedCategory)

        if (current.selectedCategory != null) {
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                categoryRatings = newCategoryRatings,
                lastRatingDelta = categoryDelta,
                correctStreak = newCorrectStreak,
                bestCorrectStreak = newBestCorrectStreak
            )
            ratingsRepository.saveCategoryRating(question.category, newCategoryRating)
        } else {
            val globalDelta = scaleGain(eloRatingDelta(current.playerRating, questionRating, isCorrect), gainFactor)
            val newPlayerRating = (current.playerRating + globalDelta).coerceAtLeast(100)
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                playerRating = newPlayerRating,
                categoryRatings = newCategoryRatings,
                lastRatingDelta = globalDelta,
                correctStreak = newCorrectStreak,
                bestCorrectStreak = newBestCorrectStreak
            )
            ratingsRepository.savePlayerRating(newPlayerRating)
            ratingsRepository.saveCategoryRating(question.category, newCategoryRating)
        }

        // Rating dynamique : la question évolue à l'inverse de l'échange ELO avec le rating de catégorie
        // du joueur (le joueur gagne X → la question perd X). On enregistre aussi la réponse (anti-grind).
        val newQuestionRating = (questionRating - categoryDelta).coerceAtLeast(100)
        val newTimesSeen = (stats?.timesSeen ?: 0L) + 1L
        val newTimesCorrect = (stats?.timesCorrect ?: 0L) + if (isCorrect) 1L else 0L
        questionStatsRepository.save(question.id, newTimesSeen, newTimesCorrect, newQuestionRating)

        // Le rating joueur vient d'évoluer → on le pousse vers Firestore (si connecté).
        pushRatings()
    }

    fun nextQuestion() {
        val current = _state.value
        val nextIndex = current.currentIndex + 1
        val (newIndex, newQuestions) = if (nextIndex >= current.questions.size) {
            0 to questionsFor(current.selectedCategory).shuffled()
        } else {
            nextIndex to current.questions
        }
        _state.value = current.copy(
            currentIndex = newIndex,
            questions = newQuestions,
            selectedAnswerIndex = null,
            answerConfirmed = false,
            lastRatingDelta = 0
        )
    }

    fun goHome() {
        _state.value = GameState(
            playerRating = _state.value.playerRating,
            categoryRatings = _state.value.categoryRatings,
            streak = _state.value.streak,
            correctStreak = streakRepository.correctStreak(null),
            bestCorrectStreak = streakRepository.bestCorrectStreak(null)
        )
    }

    private fun eloRatingDelta(playerRating: Int, questionRating: Int, correct: Boolean): Int {
        val expected = 1.0 / (1.0 + 10.0.pow((questionRating - playerRating) / 400.0))
        val result = if (correct) 1.0 else 0.0
        return (32.0 * (result - expected)).roundToInt()
    }

    /**
     * Facteur appliqué au gain selon le nombre de bonnes réponses déjà données à la question :
     * ×1 la 1re fois, ×0.5 la 2e, ×0 ensuite. Empêche de regagner indéfiniment du rating
     * sur des questions déjà maîtrisées.
     */
    private fun repeatedCorrectFactor(priorCorrect: Int): Double = when (priorCorrect) {
        0 -> 1.0
        1 -> 0.5
        else -> 0.0
    }

    private fun scaleGain(delta: Int, factor: Double): Int =
        if (factor >= 1.0) delta else (delta * factor).roundToInt()
}
