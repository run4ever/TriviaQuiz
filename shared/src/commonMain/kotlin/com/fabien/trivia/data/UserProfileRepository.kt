package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

@Serializable
private data class PseudoDto(val pseudo: String = "")

/**
 * Pseudo de l'utilisateur connecté, stocké dans le doc `players/{uid}` (à côté des ratings).
 * Pas d'unicité : l'email reste la clé du compte, le pseudo n'est qu'un nom d'affichage (multi).
 *
 * Écriture en `merge = true` pour ne PAS écraser les champs de rating du même document
 * (et réciproquement, [PlayerRatingSync] écrit aussi en merge pour préserver le pseudo).
 */
class UserProfileRepository(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    suspend fun getPseudo(uid: String): String? {
        val snapshot = doc(uid).get()
        if (!snapshot.exists) return null
        return runCatching { snapshot.data(PseudoDto.serializer()).pseudo }
            .getOrNull()
            ?.takeIf { it.isNotBlank() }
    }

    suspend fun setPseudo(uid: String, pseudo: String) {
        doc(uid).set(PseudoDto.serializer(), PseudoDto(pseudo.trim()), merge = true)
    }
}
