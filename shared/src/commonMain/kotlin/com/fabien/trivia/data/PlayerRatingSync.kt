package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/** Ratings du joueur, modèle interne (côté app). */
data class PlayerRatings(
    val global: Int,
    val categories: Map<Category, Int>
)

/**
 * Document Firestore `players/{uid}`. Les défauts (750 / vide) sont alignés sur les
 * défauts de l'app : si une valeur n'est pas écrite (= défaut), la relecture redonne 750.
 * Les catégories sont stockées par nom d'enum (clé stable, cf. slug des questions).
 */
@Serializable
private data class PlayerRatingsDto(
    val global: Int = 750,
    val categories: Map<String, Int> = emptyMap()
)

/**
 * Synchronise le rating du JOUEUR (global + 6 catégories) avec Firestore, indexé par UID.
 * Ne touche PAS au rating des questions (qui deviendra communautaire/serveur, cf. TODO point 2).
 *
 * Firestore gère lui-même le cache local + la file d'écritures hors-ligne : un [push] émis
 * sans réseau est rejoué automatiquement à la reconnexion.
 */
class PlayerRatingSync(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    /** Lit le doc cloud. null si absent (joueur jamais synchronisé). */
    suspend fun fetch(uid: String): PlayerRatings? {
        val snapshot = doc(uid).get()
        if (!snapshot.exists) return null
        val dto = snapshot.data(PlayerRatingsDto.serializer())
        return PlayerRatings(
            global = dto.global,
            categories = Category.entries.associateWith { category ->
                dto.categories[category.name] ?: 750
            }
        )
    }

    /**
     * Met à jour les champs de rating du doc cloud. `merge = true` pour ne pas écraser les
     * autres champs du même document `players/{uid}` (ex. le pseudo, cf. [UserProfileRepository]).
     */
    suspend fun push(uid: String, ratings: PlayerRatings) {
        val dto = PlayerRatingsDto(
            global = ratings.global,
            categories = ratings.categories.entries.associate { (category, rating) -> category.name to rating }
        )
        doc(uid).set(PlayerRatingsDto.serializer(), dto, merge = true)
    }
}
