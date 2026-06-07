package com.fabien.trivia.data

/**
 * État persisté par question :
 * - `timesSeen` / `timesCorrect` : historique anti-grind (fait décroître le gain ELO d'une question déjà maîtrisée)
 * - `rating` : rating dynamique local de la question (évolue selon les résultats du joueur), NULL tant
 *   que la question n'a jamais été jouée (on utilise alors le rating "graine" défini dans le code).
 */
class QuestionStatsRepository(database: TriviaDatabase) {
    private val queries = database.questionStatsQueries

    data class Stats(val timesSeen: Long, val timesCorrect: Long, val rating: Long?)

    fun getStats(questionId: String): Stats? =
        queries.selectStats(questionId).executeAsOneOrNull()?.let {
            Stats(it.times_seen, it.times_correct, it.rating)
        }

    fun save(questionId: String, timesSeen: Long, timesCorrect: Long, rating: Int) {
        queries.upsertStats(questionId, timesSeen, timesCorrect, rating.toLong())
    }
}
