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

/** Blocs « points forts » / « axes d'amélioration » de l'Accueil. */
data class HomeHighlights(
    val strengths: List<Map.Entry<Category, Int>>,
    val weaknesses: List<Map.Entry<Category, Int>>,
)

/**
 * Calcule les points forts / axes d'amélioration de l'Accueil. Règles (Fabien, 2026-06-12) :
 * - on ne considère QUE les catégories ayant reçu **≥ 2 questions** ([categoryAsked]) ;
 * - chaque bloc affiche **2 à 3** catégories — jamais une seule (sinon le bloc n'est pas montré) ;
 * - les deux blocs sont **disjoints** : jamais la même catégorie dans les deux, y compris en cas
 *   d'égalité (départagée de façon stable par l'ordre des catégories), grâce à un découpage par position.
 *
 * Il faut ≥ 4 catégories éligibles pour remplir les deux blocs ; avec 2 ou 3, on n'affiche que les
 * points forts (les 2 meilleures) ; avec moins de 2, rien.
 */
fun homeHighlights(
    categoryRatings: Map<Category, Int>,
    categoryAsked: Map<Category, Int>,
): HomeHighlights {
    val eligible = categoryRatings.entries
        .filter { (categoryAsked[it.key] ?: 0) >= 2 }
        .sortedWith(compareByDescending<Map.Entry<Category, Int>> { it.value }.thenBy { it.key.ordinal })
    val n = eligible.size
    return when {
        n < 2 -> HomeHighlights(emptyList(), emptyList())
        n < 4 -> HomeHighlights(strengths = eligible.take(2), weaknesses = emptyList())
        else -> {
            val strongCount = minOf(3, n - 2)          // laisse ≥ 2 catégories pour le bloc faible
            val weakCount = minOf(3, n - strongCount)  // garantit des blocs disjoints
            HomeHighlights(
                strengths = eligible.take(strongCount),
                weaknesses = eligible.takeLast(weakCount),
            )
        }
    }
}
