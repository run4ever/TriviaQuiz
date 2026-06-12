package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/** Une entrée de stats côté Firestore (le rating dynamique n'est PAS synchronisé : futur communautaire). */
@Serializable
private data class StatEntryDto(
    val id: String = "",
    val seen: Long = 0,
    val correct: Long = 0,
    val seenAll: Long = 0,
    val correctAll: Long = 0,
)

/** Enveloppe : ne porte QUE `questionStats` → un set(merge=true) ne touche pas rating/pseudo/séries/pool. */
@Serializable
private data class PlayerStatsDto(val questionStats: List<StatEntryDto> = emptyList())

/**
 * Synchronise les STATS PAR QUESTION (anti-grind solo + compteurs d'affichage solo+multi) sous
 * `players/{uid}.questionStats`. Stratégie alignée sur [PlayerRatingSync] : à la connexion, le cloud
 * fait foi s'il existe (on écrase le local), sinon on sème le cloud depuis le local. On évite ainsi le
 * double-comptage d'un merge additif. Le rating dynamique de la question est exclu (futur communautaire).
 */
class QuestionStatsSync(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    /** Lit les stats cloud. null si le document du joueur n'existe pas encore. */
    suspend fun fetch(uid: String): List<QuestionStatsRepository.StatEntry>? {
        val snapshot = doc(uid).get()
        if (!snapshot.exists) return null
        return snapshot.data(PlayerStatsDto.serializer()).questionStats.map {
            QuestionStatsRepository.StatEntry(it.id, it.seen, it.correct, it.seenAll, it.correctAll)
        }
    }

    /** Écrit le champ `questionStats` sans toucher aux autres champs du document. */
    suspend fun push(uid: String, entries: List<QuestionStatsRepository.StatEntry>) {
        val dto = PlayerStatsDto(
            questionStats = entries.map {
                StatEntryDto(it.questionId, it.timesSeen, it.timesCorrect, it.seenAll, it.correctAll)
            }
        )
        doc(uid).set(PlayerStatsDto.serializer(), dto, merge = true)
    }
}
