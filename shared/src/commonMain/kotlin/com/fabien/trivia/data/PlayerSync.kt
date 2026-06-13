package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/**
 * Document combiné `players/{uid}` : permet d'écrire TOUS les champs synchronisés du joueur en UNE seule
 * écriture `set(merge=true)`, au lieu d'un push par domaine. Les noms et formes des champs correspondent
 * EXACTEMENT aux DTO individuels (ratings : `global`/`categories` ; `streaks` ; `reviewPool` ;
 * `questionStats` ; `questionHistory`) → les `fetch()` respectifs de [PlayerRatingSync] / [StreakSync] /
 * [ReviewPoolSync] / [QuestionStatsSync] / [QuestionHistorySync] continuent de lire ces champs.
 * `pseudo` (écrit par [UserProfileRepository]) n'est pas inclus → préservé par `merge = true`.
 */
@Serializable
private data class PlayerDocDto(
    val global: Int = 750,
    val categories: Map<String, Int> = emptyMap(),
    val tags: Map<String, Int> = emptyMap(),
    val streaks: StreaksDto = StreaksDto(),
    val reviewPool: List<ReviewEntryDto> = emptyList(),
    val questionStats: List<StatEntryDto> = emptyList(),
    val questionHistory: List<HistoryEntryDto> = emptyList(),
)

/**
 * Push GROUPÉ de tout l'état synchronisable du joueur en UNE écriture sur `players/{uid}`. Utilisé après
 * chaque réponse (solo / multi) et au démarrage de partie, à la place des 5 pushs individuels (1 écriture
 * au lieu de 5). La synchro de CONNEXION (réconciliation par domaine) reste, elle, dans [GameViewModel].
 */
class PlayerSync(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    suspend fun pushAll(
        uid: String,
        ratings: PlayerRatings,
        streaks: StreakData,
        reviewPool: List<ReviewEntry>,
        stats: List<QuestionStatsRepository.StatEntry>,
        history: List<QuestionHistoryRepository.HistoryEntry>,
    ) {
        val dto = PlayerDocDto(
            global = ratings.global,
            categories = ratings.categories.entries.associate { (category, rating) -> category.name to rating },
            tags = ratings.tags,
            streaks = streaks.toDto(),
            reviewPool = reviewPool.map { ReviewEntryDto(it.id, it.addedAt) },
            questionStats = stats.map {
                StatEntryDto(it.questionId, it.timesSeen, it.timesCorrect, it.seenAll, it.correctAll)
            },
            questionHistory = history.map {
                HistoryEntryDto(it.questionId, it.category, it.answeredAt, it.correct)
            },
        )
        doc(uid).set(PlayerDocDto.serializer(), dto, merge = true)
    }
}
