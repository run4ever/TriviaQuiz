package com.fabien.trivia.data.multiplayer

import com.fabien.trivia.data.Category
import kotlinx.serialization.Serializable

enum class GameStatus { LOBBY, PLAYING, FINISHED }
enum class ScoringMode { SIMPLE, RAPIDITE }

/** Partie multijoueur — doc Firestore `games/{code}`. */
data class GameRoom(
    val code: String,
    val hostId: String,
    val status: GameStatus,
    val scoringMode: ScoringMode,
    val questionCount: Int?,     // null = partie ouverte (l'hôte arrête quand il veut)
    val category: Category?,     // null = toutes catégories
    val questionIds: List<String>,
    val currentIndex: Int
)

/** Joueur d'une partie — doc `games/{code}/players/{uid}`. */
data class GamePlayer(
    val id: String,
    val pseudo: String,
    val score: Int,
    val isHost: Boolean
)

@Serializable
internal data class GameRoomDto(
    val hostId: String = "",
    val status: String = "LOBBY",
    val scoringMode: String = "SIMPLE",
    val questionCount: Int? = null,
    val category: String? = null,
    val questionIds: List<String> = emptyList(),
    val currentIndex: Int = 0
)

@Serializable
internal data class GamePlayerDto(
    val pseudo: String = "",
    val score: Int = 0,
    val isHost: Boolean = false
)

/** Mise à jour partielle du statut (écrite en merge pour ne pas toucher aux autres champs). */
@Serializable
internal data class RoomStatusDto(
    val status: String = ""
)

internal fun GameRoomDto.toDomain(code: String) = GameRoom(
    code = code,
    hostId = hostId,
    status = runCatching { GameStatus.valueOf(status) }.getOrDefault(GameStatus.LOBBY),
    scoringMode = runCatching { ScoringMode.valueOf(scoringMode) }.getOrDefault(ScoringMode.SIMPLE),
    questionCount = questionCount,
    category = category?.let { name -> runCatching { Category.valueOf(name) }.getOrNull() },
    questionIds = questionIds,
    currentIndex = currentIndex
)

internal fun GamePlayerDto.toDomain(id: String) = GamePlayer(
    id = id,
    pseudo = pseudo,
    score = score,
    isHost = isHost
)
