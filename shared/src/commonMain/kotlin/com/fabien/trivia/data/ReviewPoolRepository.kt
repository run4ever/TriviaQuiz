package com.fabien.trivia.data

import kotlin.time.Clock

/**
 * Pool de révision : questions actuellement ratées, à rejouer dans l'ordre d'arrivée (pas de mélange).
 * Une mauvaise réponse (solo ou multijoueur) ajoute la question ; une bonne réponse la retire.
 * Données locales par appareil (synchro par compte = plus tard).
 */
class ReviewPoolRepository(database: TriviaDatabase) {
    private val queries = database.reviewPoolQueries

    /** IDs des questions du pool, dans l'ordre d'arrivée. */
    fun questionIds(): List<String> = queries.selectAll().executeAsList()

    fun count(): Int = queries.countAll().executeAsOne().toInt()

    /** Ajoute la question si absente (conserve sa position d'origine si déjà présente). */
    fun add(questionId: String) {
        queries.add(questionId, Clock.System.now().toEpochMilliseconds())
    }

    fun remove(questionId: String) {
        queries.remove(questionId)
    }

    /** Met à jour le pool après une réponse : retire si correcte, ajoute si fausse. */
    fun record(questionId: String, correct: Boolean) {
        if (correct) remove(questionId) else add(questionId)
    }
}
