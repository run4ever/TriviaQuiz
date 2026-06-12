package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/** Lecture complète du profil. */
@Serializable
private data class ProfileDto(
    val pseudo: String = "",
    val avatarAnimal: String = "",
    val avatarStyle: String = "",
)

/** Enveloppe pour écrire UNIQUEMENT le pseudo (merge → préserve avatar + ratings). */
@Serializable
private data class PseudoDto(val pseudo: String = "")

/** Enveloppe pour écrire UNIQUEMENT l'avatar (merge → préserve pseudo + ratings). */
@Serializable
private data class AvatarDto(val avatarAnimal: String = "", val avatarStyle: String = "")

/** Profil d'affichage (côté app) : pseudo + avatar choisi (null si non défini → défaut `avatar_bear_round`). */
data class UserProfile(val pseudo: String, val avatarAnimal: String?, val avatarStyle: String?)

/**
 * Pseudo + avatar de l'utilisateur, dans le doc `players/{uid}` (à côté des ratings). Écritures en
 * `merge = true` via des DTO dédiés par champ → ne s'écrasent pas entre eux ni les ratings/séries.
 */
class UserProfileRepository(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    /** Profil complet (pseudo + avatar). null si le doc n'existe pas. */
    suspend fun getProfile(uid: String): UserProfile? {
        val snapshot = doc(uid).get()
        if (!snapshot.exists) return null
        val dto = runCatching { snapshot.data(ProfileDto.serializer()) }.getOrNull() ?: return null
        return UserProfile(
            pseudo = dto.pseudo,
            avatarAnimal = dto.avatarAnimal.ifBlank { null },
            avatarStyle = dto.avatarStyle.ifBlank { null },
        )
    }

    suspend fun getPseudo(uid: String): String? = getProfile(uid)?.pseudo?.takeIf { it.isNotBlank() }

    suspend fun setPseudo(uid: String, pseudo: String) {
        doc(uid).set(PseudoDto.serializer(), PseudoDto(pseudo.trim()), merge = true)
    }

    suspend fun setAvatar(uid: String, animal: String, style: String) {
        doc(uid).set(AvatarDto.serializer(), AvatarDto(animal, style), merge = true)
    }
}
