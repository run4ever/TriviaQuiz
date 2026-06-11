package com.fabien.trivia.data

import kotlin.time.Clock
import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Historique des passages de questions : une ligne par réponse (solo ou multijoueur), horodatée +
 * justesse. Source de l'écran « historique par catégorie ». La catégorie est résolue côté app via la
 * banque. Données locales par appareil (synchro par compte = plus tard, cf. point 13).
 */
class QuestionHistoryRepository(database: TriviaDatabase) {
    private val queries = database.questionHistoryQueries

    /** Un passage : la date (jour local) + si la réponse était bonne. */
    data class Attempt(val questionId: String, val date: LocalDate, val correct: Boolean)

    /** Compteurs agrégés d'une question : nombre de passages + nombre de bonnes réponses. */
    data class QuestionCount(val questionId: String, val asked: Int, val correct: Int)

    /** Enregistre un passage, horodaté à maintenant. */
    fun record(questionId: String, correct: Boolean) {
        queries.insert(questionId, Clock.System.now().toEpochMilliseconds(), if (correct) 1L else 0L)
    }

    /** Compteurs (posées + bonnes) agrégés par question, sur tout l'historique. */
    fun countsByQuestion(): List<QuestionCount> =
        queries.selectCountsByQuestion().executeAsList().map {
            QuestionCount(it.question_id, it.asked.toInt(), (it.correct ?: 0L).toInt())
        }

    /** Tous les passages des questions [ids], du plus récent au plus ancien. Vide si [ids] est vide. */
    fun forQuestions(ids: List<String>): List<Attempt> {
        if (ids.isEmpty()) return emptyList()
        return queries.selectForQuestions(ids).executeAsList().map { row ->
            Attempt(
                questionId = row.question_id,
                date = Instant.fromEpochMilliseconds(row.answered_at)
                    .toLocalDateTime(TimeZone.currentSystemDefault()).date,
                correct = row.correct == 1L,
            )
        }
    }
}
