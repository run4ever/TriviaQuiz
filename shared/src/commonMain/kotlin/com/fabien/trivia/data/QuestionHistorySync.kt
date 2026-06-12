package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/**
 * Fusionne les historiques local et cloud à la connexion : c'est un journal append-only → **union** des
 * passages (dédoublonnés par question + horodatage), puis on re-plafonne à 100 par catégorie en gardant
 * les plus récents. Pas de problème de « dernier gagne » (un passage est immuable).
 */
fun mergeQuestionHistory(
    local: List<QuestionHistoryRepository.HistoryEntry>,
    cloud: List<QuestionHistoryRepository.HistoryEntry>,
): List<QuestionHistoryRepository.HistoryEntry> {
    val deduped = (local + cloud)
        .associateBy { Triple(it.questionId, it.answeredAt, it.category) }
        .values
    return deduped
        .groupBy { it.category }
        .flatMap { (_, entries) ->
            entries.sortedByDescending { it.answeredAt }.take(QuestionHistoryRepository.PER_CATEGORY_CAP)
        }
        .sortedByDescending { it.answeredAt }
}

/** Une entrée d'historique côté Firestore. */
@Serializable
private data class HistoryEntryDto(
    val id: String = "",
    val cat: String = "",
    val ts: Long = 0,
    val correct: Boolean = false,
)

/** Enveloppe : ne porte QUE `questionHistory` → un set(merge=true) ne touche pas les autres champs. */
@Serializable
private data class PlayerHistoryDto(val questionHistory: List<HistoryEntryDto> = emptyList())

/**
 * Synchronise l'HISTORIQUE des passages (plafonné à 100/cat, donc ≤ 600 entrées ≈ 40 Ko) sous
 * `players/{uid}.questionHistory`. Même doc que les autres synchros ; écrit en `merge = true`.
 * Fusion par union (cf. [mergeQuestionHistory]).
 */
class QuestionHistorySync(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    /** Lit l'historique cloud. null si le document du joueur n'existe pas encore. */
    suspend fun fetch(uid: String): List<QuestionHistoryRepository.HistoryEntry>? {
        val snapshot = doc(uid).get()
        if (!snapshot.exists) return null
        return snapshot.data(PlayerHistoryDto.serializer()).questionHistory.map {
            QuestionHistoryRepository.HistoryEntry(it.id, it.cat, it.ts, it.correct)
        }
    }

    /** Écrit le champ `questionHistory` sans toucher aux autres champs du document. */
    suspend fun push(uid: String, entries: List<QuestionHistoryRepository.HistoryEntry>) {
        val dto = PlayerHistoryDto(
            questionHistory = entries.map { HistoryEntryDto(it.questionId, it.category, it.answeredAt, it.correct) }
        )
        doc(uid).set(PlayerHistoryDto.serializer(), dto, merge = true)
    }
}
