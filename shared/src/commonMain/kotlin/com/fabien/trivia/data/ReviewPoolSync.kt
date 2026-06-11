package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/**
 * Fusionne les pools de révision local et cloud (appelée à la connexion). Le pool représente les
 * questions **actuellement ratées** ; faute d'horodatage du dernier changement par question, on fait
 * une **union par id** (on conserve l'`addedAt` le plus ancien pour préserver la position d'arrivée).
 *
 * ⚠️ Limite assumée (comme pour les séries, cf. [mergeStreaks]) : une question retirée sur un appareil
 * (réponse juste) peut être « ressuscitée » si un autre appareil, périmé, l'a encore au moment où il se
 * synchronise. Rare si on joue sur un seul appareil à la fois ; les pushs après chaque réponse gardent
 * le cloud à jour entre-temps.
 */
fun mergeReviewPool(local: List<ReviewEntry>, cloud: List<ReviewEntry>): List<ReviewEntry> {
    val earliestById = HashMap<String, Long>()
    (local + cloud).forEach { entry ->
        val existing = earliestById[entry.id]
        earliestById[entry.id] = if (existing == null) entry.addedAt else minOf(existing, entry.addedAt)
    }
    return earliestById.entries
        .map { ReviewEntry(it.key, it.value) }
        .sortedBy { it.addedAt }
}

/** Une entrée du pool côté Firestore. */
@Serializable
private data class ReviewEntryDto(val id: String = "", val addedAt: Long = 0)

/** Enveloppe : ne porte QUE le champ `reviewPool` → un set(merge=true) ne touche pas rating/pseudo/streaks. */
@Serializable
private data class PlayerReviewPoolDto(val reviewPool: List<ReviewEntryDto> = emptyList())

/**
 * Synchronise le POOL DE RÉVISION du joueur avec Firestore, sous `players/{uid}.reviewPool`. Même doc
 * que [PlayerRatingSync] / [StreakSync] / [UserProfileRepository] ; écrit en `merge = true` pour
 * préserver les autres champs. Firestore gère le cache local + la file hors-ligne.
 */
class ReviewPoolSync(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    /** Lit le pool cloud. null si le document du joueur n'existe pas encore (jamais synchronisé). */
    suspend fun fetch(uid: String): List<ReviewEntry>? {
        val snapshot = doc(uid).get()
        if (!snapshot.exists) return null
        return snapshot.data(PlayerReviewPoolDto.serializer()).reviewPool
            .map { ReviewEntry(it.id, it.addedAt) }
    }

    /** Écrit le champ `reviewPool` sans toucher aux autres champs du document. */
    suspend fun push(uid: String, entries: List<ReviewEntry>) {
        val dto = PlayerReviewPoolDto(reviewPool = entries.map { ReviewEntryDto(it.id, it.addedAt) })
        doc(uid).set(PlayerReviewPoolDto.serializer(), dto, merge = true)
    }
}
