package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/**
 * Photo complète des séries d'un joueur (modèle interne côté app), telle qu'échangée avec le cloud.
 * Les dates sont des epoch days ; `0` = inconnue / jamais (sentinelle, une vraie date de jeu ne
 * tombera jamais sur 1970-01-01).
 *
 * - série quotidienne : [dailyCount] jours consécutifs + [dailyLastDay] dernier jour compté.
 * - séries de bonnes réponses EN COURS : [currentGlobal] + [currentByCategory].
 * - RECORDS de bonnes réponses : [bestGlobal] + [bestByCategory], et leurs dates [bestDateGlobal] /
 *   [bestDateByCategory].
 */
data class StreakData(
    val dailyCount: Int,
    val dailyLastDay: Int,
    val currentGlobal: Int,
    val currentByCategory: Map<Category, Int>,
    val bestGlobal: Int,
    val bestByCategory: Map<Category, Int>,
    val bestDateGlobal: Int,
    val bestDateByCategory: Map<Category, Int>,
)

/**
 * Fusionne les séries locales et cloud (appelée à la connexion). Règles décidées avec Fabien :
 * - **série quotidienne** : le **dernier jour compté le plus récent gagne** (à jour égal → plus grand
 *   compteur). Ne régresse jamais, ne sur-compte jamais ; `registerPlay()` enchaîne ensuite normalement.
 * - **séries en cours** : **max** (on ne perd pas sa série en ouvrant un 2e appareil ; ensuite chaque
 *   réponse écrase la valeur, une mauvaise réponse repoussant 0).
 * - **records** : le **plus haut gagne**, avec la date de CE record ; à longueur égale on garde la date
 *   connue la plus ancienne (1re fois atteinte).
 */
fun mergeStreaks(local: StreakData, cloud: StreakData): StreakData {
    val (dailyCount, dailyLastDay) = when {
        local.dailyLastDay > cloud.dailyLastDay -> local.dailyCount to local.dailyLastDay
        cloud.dailyLastDay > local.dailyLastDay -> cloud.dailyCount to cloud.dailyLastDay
        else -> maxOf(local.dailyCount, cloud.dailyCount) to local.dailyLastDay
    }
    val bestPerCat = Category.entries.associateWith {
        mergeBest(
            local.bestByCategory[it] ?: 0, local.bestDateByCategory[it] ?: 0,
            cloud.bestByCategory[it] ?: 0, cloud.bestDateByCategory[it] ?: 0,
        )
    }
    val (bestGlobal, bestDateGlobal) =
        mergeBest(local.bestGlobal, local.bestDateGlobal, cloud.bestGlobal, cloud.bestDateGlobal)
    return StreakData(
        dailyCount = dailyCount,
        dailyLastDay = dailyLastDay,
        currentGlobal = maxOf(local.currentGlobal, cloud.currentGlobal),
        currentByCategory = Category.entries.associateWith {
            maxOf(local.currentByCategory[it] ?: 0, cloud.currentByCategory[it] ?: 0)
        },
        bestGlobal = bestGlobal,
        bestByCategory = bestPerCat.mapValues { it.value.first },
        bestDateGlobal = bestDateGlobal,
        bestDateByCategory = bestPerCat.mapValues { it.value.second },
    )
}

/** Record + sa date : plus haut gagne ; à égalité, date connue (>0) la plus ancienne. */
private fun mergeBest(lBest: Int, lDate: Int, cBest: Int, cDate: Int): Pair<Int, Int> = when {
    lBest > cBest -> lBest to lDate
    cBest > lBest -> cBest to cDate
    else -> lBest to (listOf(lDate, cDate).filter { it > 0 }.minOrNull() ?: 0)
}

/** Sous-objet `streaks` du document `players/{uid}`. Catégories par nom d'enum (clé stable). */
@Serializable
private data class StreaksDto(
    val dailyCount: Int = 0,
    val dailyLastDay: Int = 0,
    val currentGlobal: Int = 0,
    val currentByCategory: Map<String, Int> = emptyMap(),
    val bestGlobal: Int = 0,
    val bestByCategory: Map<String, Int> = emptyMap(),
    val bestDateGlobal: Int = 0,
    val bestDateByCategory: Map<String, Int> = emptyMap(),
)

/** Enveloppe : ne porte QUE le champ `streaks` → un set(merge=true) ne touche pas rating/pseudo. */
@Serializable
private data class PlayerStreaksDto(val streaks: StreaksDto = StreaksDto())

private fun StreaksDto.toData() = StreakData(
    dailyCount = dailyCount,
    dailyLastDay = dailyLastDay,
    currentGlobal = currentGlobal,
    currentByCategory = Category.entries.associateWith { currentByCategory[it.name] ?: 0 },
    bestGlobal = bestGlobal,
    bestByCategory = Category.entries.associateWith { bestByCategory[it.name] ?: 0 },
    bestDateGlobal = bestDateGlobal,
    bestDateByCategory = Category.entries.associateWith { bestDateByCategory[it.name] ?: 0 },
)

private fun StreakData.toDto() = StreaksDto(
    dailyCount = dailyCount,
    dailyLastDay = dailyLastDay,
    currentGlobal = currentGlobal,
    currentByCategory = currentByCategory.entries.associate { (c, v) -> c.name to v },
    bestGlobal = bestGlobal,
    bestByCategory = bestByCategory.entries.associate { (c, v) -> c.name to v },
    bestDateGlobal = bestDateGlobal,
    bestDateByCategory = bestDateByCategory.entries.associate { (c, v) -> c.name to v },
)

/**
 * Synchronise les SÉRIES du joueur (quotidienne + bonnes réponses en cours et records) avec Firestore,
 * sous `players/{uid}.streaks`. Même doc que [PlayerRatingSync] et [UserProfileRepository] ; on écrit
 * en `merge = true` pour préserver rating et pseudo. Firestore gère cache local + file hors-ligne.
 */
class StreakSync(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private fun doc(uid: String) = firestore.collection("players").document(uid)

    /** Lit les séries cloud. null si le doc n'existe pas encore (joueur jamais synchronisé). */
    suspend fun fetch(uid: String): StreakData? {
        val snapshot = doc(uid).get()
        if (!snapshot.exists) return null
        return snapshot.data(PlayerStreaksDto.serializer()).streaks.toData()
    }

    /** Écrit le sous-objet `streaks` sans toucher aux autres champs du document. */
    suspend fun push(uid: String, data: StreakData) {
        doc(uid).set(PlayerStreaksDto.serializer(), PlayerStreaksDto(streaks = data.toDto()), merge = true)
    }
}
