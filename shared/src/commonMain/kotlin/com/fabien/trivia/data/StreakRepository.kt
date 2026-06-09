package com.fabien.trivia.data

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn

/**
 * Série quotidienne (« streak ») : nombre de jours consécutifs où le joueur a joué.
 *
 * Stockée en local dans la table clé→valeur `player_ratings` (clés dédiées, donc sans migration
 * de schéma ni interférence avec la synchro des ratings qui ne lit que `"global"` + noms de
 * catégories). Données propres à l'appareil pour l'instant (synchro par compte = plus tard).
 */
class StreakRepository(database: TriviaDatabase) {
    private val queries = database.ratingsQueries

    private fun read(key: String): Int? = queries.getRating(key).executeAsOneOrNull()?.toInt()

    private fun todayEpochDay(): Int =
        Clock.System.todayIn(TimeZone.currentSystemDefault()).toEpochDays()

    /**
     * À appeler quand le joueur joue : incrémente la série si on était à hier, la (re)met à 1
     * sinon, et ne fait rien si on a déjà joué aujourd'hui. Renvoie la série courante.
     */
    fun registerPlay(): Int {
        val today = todayEpochDay()
        val last = read(KEY_LAST_DAY)
        val streak = read(KEY_COUNT) ?: 0
        if (last == today) return streak
        val newStreak = if (last == today - 1) streak + 1 else 1
        queries.upsertRating(KEY_COUNT, newStreak.toLong())
        queries.upsertRating(KEY_LAST_DAY, today.toLong())
        return newStreak
    }

    /** Série à afficher : conservée si le dernier jour joué est aujourd'hui ou hier, sinon 0 (rompue). */
    fun currentStreak(): Int {
        val last = read(KEY_LAST_DAY) ?: return 0
        val streak = read(KEY_COUNT) ?: 0
        val today = todayEpochDay()
        return if (last == today || last == today - 1) streak else 0
    }

    // --- Suite de bonnes réponses consécutives (solo) ---
    // Persistée : continue d'une session/d'un jour à l'autre, se brise QUE sur une mauvaise
    // réponse (pas de notion de date). Calquée sur les ratings : une **globale** (mode « toutes
    // catégories ») + une **par catégorie**. [category] = null → globale.

    fun correctStreak(category: Category?): Int = read(currentKey(category)) ?: 0
    fun bestCorrectStreak(category: Category?): Int = read(bestKey(category)) ?: 0

    /**
     * Enregistre une réponse à une question de [category] : met à jour la suite de cette catégorie,
     * et — seulement en mode « toutes catégories » ([includeGlobal] = true) — la suite globale.
     * Le mode catégorie ne touche donc PAS la globale.
     */
    fun recordAnswer(category: Category, correct: Boolean, includeGlobal: Boolean) {
        bump(currentKey(category), bestKey(category), correct)
        if (includeGlobal) bump(currentKey(null), bestKey(null), correct)
    }

    private fun bump(currentKey: String, bestKey: String, correct: Boolean) {
        val current = if (correct) (read(currentKey) ?: 0) + 1 else 0
        queries.upsertRating(currentKey, current.toLong())
        val best = maxOf(read(bestKey) ?: 0, current)
        queries.upsertRating(bestKey, best.toLong())
    }

    private fun currentKey(category: Category?) =
        if (category == null) "correct_streak" else "correct_streak_${category.name}"

    private fun bestKey(category: Category?) =
        if (category == null) "best_correct_streak" else "best_correct_streak_${category.name}"

    private companion object {
        const val KEY_COUNT = "streak_count"
        const val KEY_LAST_DAY = "streak_lastday"
    }
}
