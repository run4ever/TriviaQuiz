package com.fabien.trivia.ui.theme

import com.fabien.trivia.data.Category

/** Rating attribué à chaque catégorie à l'inscription (= défaut de `GameState.categoryRatings`). */
const val SIGNUP_RATING = 750

/**
 * Échelle de niveau du projet (libellés et seuils choisis par Fabien). `min` = rating plancher
 * du rang. Source unique pour l'Accueil, les Catégories et le Profil.
 */
enum class Rank(val min: Int, val label: String) {
    NOVICE(0, "Novice"),
    APPRENTI(500, "Apprenti"),
    INTERMEDIAIRE(800, "Intermédiaire"),
    CONFIRME(1100, "Confirmé"),
    EXPERT(1400, "Expert"),
    MAITRE(1700, "Maître");

    companion object {
        /** Rang correspondant à un rating. */
        fun of(rating: Int): Rank = entries.lastOrNull { rating >= it.min } ?: NOVICE

        /** Rang suivant (null si déjà au max), pour la progression « X pts pour <rang> ». */
        fun next(rating: Int): Rank? = entries.firstOrNull { it.min > rating }
    }
}

/** Libellé de niveau (même source partout). */
fun Int.levelName(): String = Rank.of(this).label

/**
 * Progression (0f..1f) vers le rang suivant. 1f si déjà au rang max.
 */
fun progressToNextRank(rating: Int): Float {
    val current = Rank.of(rating)
    val next = Rank.next(rating) ?: return 1f
    val span = (next.min - current.min).toFloat()
    if (span <= 0f) return 1f
    return ((rating - current.min) / span).coerceIn(0f, 1f)
}

// --- Seuils des blocs de l'Accueil (ajustables) ---
const val STRENGTH_MIN = 1200 // « Tes points forts » : rating >= ce seuil
const val WEAKNESS_MAX = 1000  // « Tes axes d'amélioration » : rating <= ce seuil

fun Map<Category, Int>.strengths(): List<Map.Entry<Category, Int>> =
    entries.filter { it.value >= STRENGTH_MIN }.sortedByDescending { it.value }.take(3)

fun Map<Category, Int>.weaknesses(): List<Map.Entry<Category, Int>> =
    entries.filter { it.value <= WEAKNESS_MAX }.sortedBy { it.value }.take(3)
