package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable
import kotlin.time.Clock

@Serializable
private data class FriendDto(val addedAt: Long = 0)

/**
 * Relations d'amis — modèle **FOLLOW (à sens unique)** : `players/{uid}/friends/{friendUid}` = { addedAt }.
 * « Mes amis » = ma sous-collection (je l'ajoute sans qu'il ait à accepter).
 * Règle Firestore : `match /players/{uid}/friends/{fid} { allow read, write: if request.auth.uid == uid }`.
 */
class FriendsRepository(private val firestore: FirebaseFirestore = Firebase.firestore) {
    private fun friends(uid: String) =
        firestore.collection("players").document(uid).collection("friends")

    /** Ajoute [friendUid] à mes amis. */
    suspend fun add(myUid: String, friendUid: String) {
        friends(myUid).document(friendUid)
            .set(FriendDto.serializer(), FriendDto(addedAt = Clock.System.now().toEpochMilliseconds()))
    }

    /** Retire [friendUid] de mes amis. */
    suspend fun remove(myUid: String, friendUid: String) {
        friends(myUid).document(friendUid).delete()
    }

    /** UID de mes amis. */
    suspend fun friendUids(myUid: String): List<String> =
        friends(myUid).get().documents.map { it.id }

    /** Vrai si [friendUid] est déjà dans mes amis. */
    suspend fun isFriend(myUid: String, friendUid: String): Boolean =
        friends(myUid).document(friendUid).get().exists
}
