package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/** Doc `players` réduit à son seul `pseudo` : sert à remplacer chaque doc en n'y gardant que le pseudo. */
@Serializable
private data class PseudoOnlyDto(val pseudo: String = "")

/**
 * Outil d'administration sur la collection `players` (réservé au compte admin).
 *
 * ⚠️ Par défaut, un joueur ne peut lire/écrire que SON propre doc (`request.auth.uid == uid`). Pour que
 * [resetAllPlayersData] fonctionne (lister + réécrire tous les docs), il faut une règle Firestore
 * autorisant l'admin à lire/écrire n'importe quel doc `players`, p. ex. (TEMPORAIRE) :
 *
 *   match /players/{uid} {
 *     allow read, write: if request.auth.uid == uid
 *                        || request.auth.token.email == "fabien.laurette@gmail.com";
 *   }
 *
 * À retirer une fois le nettoyage fait.
 */
class PlayerAdminRepository(private val firestore: FirebaseFirestore = Firebase.firestore) {
    private val players = firestore.collection("players")

    /**
     * Réinitialise les données liées aux QUESTIONS de TOUS les joueurs (ratings, séries, pool de révision,
     * stats, historique) en **CONSERVANT le pseudo**. Pour chaque doc `players/{uid}` : on relit le pseudo
     * puis on **remplace** le doc par `{ pseudo }` (`set` SANS merge) → tous les autres champs disparaissent
     * et seront relus à leur valeur par défaut (= compte neuf). Renvoie le nombre de joueurs traités.
     *
     * Fiable vis-à-vis de l'encodage des valeurs par défaut : un vrai pseudo est non vide, donc toujours
     * réécrit ; un doc sans pseudo (invité anonyme) repart simplement sans pseudo, ce qui est l'état neuf.
     */
    suspend fun resetAllPlayersData(): Int {
        val snapshot = players.get()
        snapshot.documents.forEach { doc ->
            val pseudo = runCatching { doc.data(PseudoOnlyDto.serializer()).pseudo }.getOrNull().orEmpty()
            players.document(doc.id).set(PseudoOnlyDto.serializer(), PseudoOnlyDto(pseudo))
        }
        return snapshot.documents.size
    }
}
