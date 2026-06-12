package com.fabien.trivia.data

/**
 * État persisté par question :
 * - `timesSeen` / `timesCorrect` : historique anti-grind SOLO (fait décroître le gain ELO d'une question
 *   déjà maîtrisée). Non alimenté par le multi pour ne pas fausser l'ELO solo.
 * - `seenAll` / `correctAll` : compteurs « affichage » SOLO + MULTI (source des compteurs du Profil).
 * - `rating` : rating dynamique local de la question, NULL tant que jamais jouée (on utilise alors la
 *   graine du code). EXCLU de la synchro par compte (deviendra communautaire, calculé côté serveur).
 */
class QuestionStatsRepository(database: TriviaDatabase) {
    private val queries = database.questionStatsQueries

    data class Stats(
        val timesSeen: Long,
        val timesCorrect: Long,
        val rating: Long?,
        val seenAll: Long,
        val correctAll: Long,
    )

    /** Compteur « affichage » d'une question : passages + bonnes réponses (solo + multi). */
    data class Count(val questionId: String, val seenAll: Int, val correctAll: Int)

    /** Une entrée pour la synchro par compte (le rating dynamique est volontairement exclu). */
    data class StatEntry(
        val questionId: String,
        val timesSeen: Long,
        val timesCorrect: Long,
        val seenAll: Long,
        val correctAll: Long,
    )

    fun getStats(questionId: String): Stats? =
        queries.selectStats(questionId).executeAsOneOrNull()?.let {
            Stats(it.times_seen, it.times_correct, it.rating, it.seen_all, it.correct_all)
        }

    /**
     * Sauvegarde solo : met à jour les compteurs anti-grind (`timesSeen`/`timesCorrect`), le rating
     * dynamique ET les compteurs d'affichage (`seenAll`/`correctAll`).
     */
    fun save(
        questionId: String,
        timesSeen: Long,
        timesCorrect: Long,
        rating: Int,
        seenAll: Long,
        correctAll: Long,
    ) {
        queries.upsertStats(questionId, timesSeen, timesCorrect, rating.toLong(), seenAll, correctAll)
    }

    /**
     * Réponse MULTI : n'incrémente QUE les compteurs d'affichage (`seenAll`/`correctAll`), en préservant
     * les compteurs solo (`timesSeen`/`timesCorrect`) et le rating dynamique pour ne pas fausser l'ELO.
     */
    fun recordDisplayCount(questionId: String, correct: Boolean) {
        val s = getStats(questionId)
        queries.upsertStats(
            questionId,
            s?.timesSeen ?: 0L,
            s?.timesCorrect ?: 0L,
            s?.rating,
            (s?.seenAll ?: 0L) + 1L,
            (s?.correctAll ?: 0L) + if (correct) 1L else 0L,
        )
    }

    /** Compteurs d'affichage (solo + multi) par question vue, pour les stats du Profil. */
    fun totals(): List<Count> =
        queries.selectTotals().executeAsList().map {
            Count(it.question_id, it.seen_all.toInt(), it.correct_all.toInt())
        }

    /** Snapshot complet pour la synchro (sans le rating dynamique). */
    fun snapshot(): List<StatEntry> =
        queries.selectAllForSync().executeAsList().map {
            StatEntry(it.question_id, it.times_seen, it.times_correct, it.seen_all, it.correct_all)
        }

    /** Remplace tout l'état local par [entries] (rating remis à NULL = graine du code). Pour la synchro. */
    fun write(entries: List<StatEntry>) {
        queries.deleteAll()
        entries.forEach {
            queries.upsertStats(it.questionId, it.timesSeen, it.timesCorrect, null, it.seenAll, it.correctAll)
        }
    }

    /** Efface tout (réinitialisation à la déconnexion). */
    fun deleteAll() = queries.deleteAll()
}
