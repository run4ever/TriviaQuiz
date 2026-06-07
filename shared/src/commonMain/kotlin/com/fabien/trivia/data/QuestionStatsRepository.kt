package com.fabien.trivia.data

/**
 * Historique par question (anti-grind) : combien de fois chaque question a été vue
 * et réussie, pour faire décroître le gain ELO d'une question déjà maîtrisée.
 */
class QuestionStatsRepository(database: TriviaDatabase) {
    private val queries = database.questionStatsQueries

    /** Nombre de fois où la question a déjà été répondue correctement par le joueur. */
    fun getTimesCorrect(questionId: String): Int =
        queries.selectStats(questionId).executeAsOneOrNull()?.times_correct?.toInt() ?: 0

    /** Enregistre une nouvelle réponse (vue +1, et réussie +1 si correcte). */
    fun recordAnswer(questionId: String, correct: Boolean) {
        val current = queries.selectStats(questionId).executeAsOneOrNull()
        val timesSeen = (current?.times_seen ?: 0L) + 1L
        val timesCorrect = (current?.times_correct ?: 0L) + if (correct) 1L else 0L
        queries.upsertStats(questionId, timesSeen, timesCorrect)
    }
}
