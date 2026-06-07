package com.fabien.trivia.ui.game

import androidx.lifecycle.ViewModel
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.DatabaseDriverFactory
import com.fabien.trivia.data.Question
import com.fabien.trivia.data.QuestionRepository
import com.fabien.trivia.data.QuestionStatsRepository
import com.fabien.trivia.data.RatingsRepository
import com.fabien.trivia.data.TriviaDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    val selectedCategory: Category? = null
) {
    val displayedRating: Int
        get() = if (selectedCategory != null) categoryRatings[selectedCategory] ?: 750 else playerRating
}

class GameViewModel(driverFactory: DatabaseDriverFactory) : ViewModel() {
    private val database = TriviaDatabase(driverFactory.createDriver())
    private val ratingsRepository = RatingsRepository(database)
    private val questionStatsRepository = QuestionStatsRepository(database)
    private val _state = MutableStateFlow(GameState(
        playerRating = ratingsRepository.getPlayerRating(),
        categoryRatings = ratingsRepository.getAllCategoryRatings()
    ))
    val state: StateFlow<GameState> = _state.asStateFlow()

    fun goToCategorySelect() {
        _state.value = _state.value.copy(phase = GamePhase.CATEGORY_SELECT)
    }

    fun startGame(category: Category? = null) {
        val questions = if (category != null) {
            QuestionRepository.getByCategory(category).shuffled()
        } else {
            QuestionRepository.questions.shuffled()
        }
        _state.value = GameState(
            phase = GamePhase.PLAYING,
            questions = questions,
            selectedCategory = category,
            playerRating = _state.value.playerRating,
            categoryRatings = _state.value.categoryRatings
        )
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

        if (current.selectedCategory != null) {
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                categoryRatings = newCategoryRatings,
                lastRatingDelta = categoryDelta
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
                lastRatingDelta = globalDelta
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
    }

    fun nextQuestion() {
        val current = _state.value
        val nextIndex = current.currentIndex + 1
        val (newIndex, newQuestions) = if (nextIndex >= current.questions.size) {
            val questions = if (current.selectedCategory != null) {
                QuestionRepository.getByCategory(current.selectedCategory).shuffled()
            } else {
                QuestionRepository.questions.shuffled()
            }
            0 to questions
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
            categoryRatings = _state.value.categoryRatings
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
