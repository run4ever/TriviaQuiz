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

    private companion object {
        const val KEY_COUNT = "streak_count"
        const val KEY_LAST_DAY = "streak_lastday"
    }
}
