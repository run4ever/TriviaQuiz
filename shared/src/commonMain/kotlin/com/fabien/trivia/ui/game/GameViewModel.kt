package com.fabien.trivia.ui.game

import androidx.lifecycle.ViewModel
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.Question
import com.fabien.trivia.data.QuestionRepository
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
    val playerRating: Int = 1000,
    val categoryRatings: Map<Category, Int> = Category.entries.associateWith { 1000 },
    val lastRatingDelta: Int = 0,
    val selectedCategory: Category? = null
) {
    val displayedRating: Int
        get() = if (selectedCategory != null) categoryRatings[selectedCategory] ?: 1000 else playerRating
}

class GameViewModel : ViewModel() {
    private val _state = MutableStateFlow(GameState())
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

        val categoryRating = current.categoryRatings[question.category] ?: 1000
        val categoryDelta = eloRatingDelta(categoryRating, question.rating, isCorrect)
        val newCategoryRatings = current.categoryRatings +
            (question.category to (categoryRating + categoryDelta).coerceAtLeast(100))

        if (current.selectedCategory != null) {
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                categoryRatings = newCategoryRatings,
                lastRatingDelta = categoryDelta
            )
        } else {
            val globalDelta = eloRatingDelta(current.playerRating, question.rating, isCorrect)
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                playerRating = (current.playerRating + globalDelta).coerceAtLeast(100),
                categoryRatings = newCategoryRatings,
                lastRatingDelta = globalDelta
            )
        }
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
}
