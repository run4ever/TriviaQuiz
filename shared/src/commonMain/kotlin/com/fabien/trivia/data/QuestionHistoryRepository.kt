package com.fabien.trivia.data

import kotlin.time.Clock
import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Historique des passages de questions : une ligne par réponse (solo ou multijoueur), horodatée +
 * justesse + catégorie. **Plafonné à 100 passages par catégorie** (trim après chaque insertion) → volume
 * borné, synchronisable par compte dans un seul document. Source de l'écran « historique par catégorie »
 * (désormais une liste plate des passages récents).
 */
class QuestionHistoryRepository(database: TriviaDatabase) {
    private val queries = database.questionHistoryQueries

    /** Un passage : la question, la date (jour local) et si la réponse était bonne. */
    data class Attempt(val questionId: String, val date: LocalDate, val correct: Boolean)

    /** Une entrée brute pour la synchro par compte (catégorie + horodatage conservés). */
    data class HistoryEntry(
        val questionId: String,
        val category: String,
        val answeredAt: Long,
        val correct: Boolean,
    )

    companion object {
        const val PER_CATEGORY_CAP = 100
    }

    /** Enregistre un passage horodaté à maintenant, puis plafonne la catégorie à 100. */
    fun record(questionId: String, category: String, correct: Boolean) {
        queries.insert(questionId, Clock.System.now().toEpochMilliseconds(), if (correct) 1L else 0L, category)
        queries.trimCategory(category)
    }

    /** Les passages récents d'une catégorie (au plus 100), du plus récent au plus ancien. */
    fun recentForCategory(category: String): List<Attempt> =
        queries.selectRecentForCategory(category).executeAsList().map { row ->
            Attempt(
                questionId = row.question_id,
                date = Instant.fromEpochMilliseconds(row.answered_at)
                    .toLocalDateTime(TimeZone.currentSystemDefault()).date,
                correct = row.correct == 1L,
            )
        }

    /** Snapshot complet (déjà plafonné à 100/cat) pour la synchro. */
    fun snapshot(): List<HistoryEntry> =
        queries.selectAllForSync().executeAsList().map {
            HistoryEntry(it.question_id, it.category ?: "", it.answered_at, it.correct == 1L)
        }

    /** Remplace tout l'historique local par [entries] (catégories conservées). Pour la synchro. */
    fun write(entries: List<HistoryEntry>) {
        queries.deleteAll()
        entries.forEach {
            queries.insert(it.questionId, it.answeredAt, if (it.correct) 1L else 0L, it.category)
        }
    }

    /** Efface tout (réinitialisation à la déconnexion). */
    fun deleteAll() = queries.deleteAll()
}
