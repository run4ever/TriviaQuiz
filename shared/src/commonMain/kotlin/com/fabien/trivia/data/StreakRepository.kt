package com.fabien.trivia.data

import kotlin.time.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

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

    // `.toInt()` : robuste que kotlinx-datetime renvoie un Int (ancien) ou un Long (0.6.2+).
    private fun todayEpochDay(): Int =
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date.toEpochDays().toInt()

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

    /** Date à laquelle la meilleure série a été atteinte. null si pas de record (ou record d'avant le suivi des dates). */
    fun bestStreakDate(category: Category?): LocalDate? =
        read(bestDateKey(category))?.let { LocalDate.fromEpochDays(it.toLong()) }

    /**
     * Enregistre une réponse à une question de [category] : met à jour la suite de cette catégorie,
     * et — seulement en mode « toutes catégories » ([includeGlobal] = true) — la suite globale.
     * Le mode catégorie ne touche donc PAS la globale.
     */
    fun recordAnswer(category: Category, correct: Boolean, includeGlobal: Boolean) {
        bump(category, correct)
        if (includeGlobal) bump(null, correct)
    }

    private fun bump(category: Category?, correct: Boolean) {
        val current = if (correct) (read(currentKey(category)) ?: 0) + 1 else 0
        queries.upsertRating(currentKey(category), current.toLong())
        // Nouveau record → on mémorise la longueur ET la date d'aujourd'hui.
        if (current > (read(bestKey(category)) ?: 0)) {
            queries.upsertRating(bestKey(category), current.toLong())
            queries.upsertRating(bestDateKey(category), todayEpochDay().toLong())
        }
    }

    private fun currentKey(category: Category?) =
        if (category == null) "correct_streak" else "correct_streak_${category.name}"

    private fun bestKey(category: Category?) =
        if (category == null) "best_correct_streak" else "best_correct_streak_${category.name}"

    private fun bestDateKey(category: Category?) =
        if (category == null) "best_correct_streak_date" else "best_correct_streak_date_${category.name}"

    private companion object {
        const val KEY_COUNT = "streak_count"
        const val KEY_LAST_DAY = "streak_lastday"
    }
}
