package com.fabien.trivia.data

import kotlin.time.Clock

/** Une entrée du pool : l'id de la question + son horodatage d'arrivée (pour l'ordre et la fusion cloud). */
data class ReviewEntry(val id: String, val addedAt: Long)

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

    /** Photo complète (id + horodatage), dans l'ordre d'arrivée — pour la synchro par compte. */
    fun snapshot(): List<ReviewEntry> =
        queries.selectAllWithTime().executeAsList().map { ReviewEntry(it.question_id, it.added_at) }

    /** Remplace tout le pool par [entries] (résultat d'une fusion locale ↔ cloud), en une transaction. */
    fun write(entries: List<ReviewEntry>) {
        queries.transaction {
            queries.deleteAll()
            entries.forEach { queries.upsert(it.id, it.addedAt) }
        }
    }
}
