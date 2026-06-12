package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/** Fiche publique d'un joueur (pour recherche + affichage d'un ami). */
data class DirectoryEntry(val uid: String, val pseudo: String, val rating: Int)

@Serializable
private data class DirectoryDto(
    val pseudo: String = "",
    val pseudoLower: String = "",
    val rating: Int = 750,
)

/**
 * Collection publique `directory/{uid}` = { pseudo, pseudoLower, rating }. Permet de RECHERCHER un joueur
 * par pseudo et d'afficher le pseudo + niveau d'un ami sans ouvrir `players` (privé) en lecture.
 * Règles Firestore : `allow read: if request.auth != null ; allow write: if request.auth.uid == uid`.
 */
class DirectoryRepository(private val firestore: FirebaseFirestore = Firebase.firestore) {
    private val directory get() = firestore.collection("directory")

    /** Met à jour (merge) sa propre fiche publique. À appeler à la connexion / au changement de pseudo. */
    suspend fun upsert(uid: String, pseudo: String, rating: Int) {
        directory.document(uid).set(
            DirectoryDto.serializer(),
            DirectoryDto(pseudo = pseudo, pseudoLower = pseudo.lowercase(), rating = rating),
            merge = true,
        )
    }

    /** Fiche d'un joueur (null si absente). */
    suspend fun get(uid: String): DirectoryEntry? {
        val snap = directory.document(uid).get()
        if (!snap.exists) return null
        val dto = snap.data(DirectoryDto.serializer())
        return DirectoryEntry(uid, dto.pseudo, dto.rating)
    }

    /** Fiches de plusieurs joueurs (pour afficher la liste d'amis) ; ignore les absents. */
    suspend fun getMany(uids: List<String>): List<DirectoryEntry> = uids.mapNotNull { get(it) }

    /**
     * Recherche par préfixe de pseudo (insensible à la casse). V1 : filtrage CÔTÉ CLIENT (lit toute la
     * collection `directory`) — simple et suffisant à petite échelle ; passer à une requête Firestore par
     * préfixe (`orderBy(pseudoLower).startAt/endAt`) si le répertoire grossit. Exclut [excludeUid].
     */
    suspend fun search(query: String, excludeUid: String, limit: Int = 20): List<DirectoryEntry> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return emptyList()
        return directory.get().documents
            .mapNotNull { doc ->
                if (doc.id == excludeUid) return@mapNotNull null
                val dto = doc.data(DirectoryDto.serializer())
                if (!dto.pseudoLower.startsWith(q)) return@mapNotNull null
                DirectoryEntry(doc.id, dto.pseudo, dto.rating)
            }
            .sortedBy { it.pseudo.lowercase() }
            .take(limit)
    }
}
