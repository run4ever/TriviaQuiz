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
    val currentIndex: Int,
    val currentStartedAt: Long   // epoch millis (horloge de l'hôte) du début de la question courante
)

/** Joueur d'une partie — doc `games/{code}/players/{uid}`. */
data class GamePlayer(
    val id: String,
    val pseudo: String,
    val score: Int,
    val isHost: Boolean,
    val answeredIndex: Int,      // index de la dernière question répondue (-1 = aucune)
    val lastChoice: Int          // option choisie à cette question (-1 = aucune)
)

@Serializable
internal data class GameRoomDto(
    val hostId: String = "",
    val status: String = "LOBBY",
    val scoringMode: String = "SIMPLE",
    val questionCount: Int? = null,
    val category: String? = null,
    val questionIds: List<String> = emptyList(),
    val currentIndex: Int = 0,
    val currentStartedAt: Long = 0
)

@Serializable
internal data class GamePlayerDto(
    val pseudo: String = "",
    val score: Int = 0,
    val isHost: Boolean = false,
    val answeredIndex: Int = -1,
    val lastChoice: Int = -1
)

/** Mise à jour partielle du statut (écrite en merge pour ne pas toucher aux autres champs). */
@Serializable
internal data class RoomStatusDto(
    val status: String = ""
)

/** Avancement de la partie (statut + question courante), écrit en merge par l'hôte. */
@Serializable
internal data class RoomProgressDto(
    val status: String = "",
    val currentIndex: Int = 0,
    val currentStartedAt: Long = 0
)

/** Réponse d'un joueur (score cumulé + choix), écrite en merge dans son propre doc. */
@Serializable
internal data class PlayerAnswerDto(
    val score: Int = 0,
    val answeredIndex: Int = -1,
    val lastChoice: Int = -1
)

internal fun GameRoomDto.toDomain(code: String) = GameRoom(
    code = code,
    hostId = hostId,
    status = runCatching { GameStatus.valueOf(status) }.getOrDefault(GameStatus.LOBBY),
    scoringMode = runCatching { ScoringMode.valueOf(scoringMode) }.getOrDefault(ScoringMode.SIMPLE),
    questionCount = questionCount,
    category = category?.let { name -> runCatching { Category.valueOf(name) }.getOrNull() },
    questionIds = questionIds,
    currentIndex = currentIndex,
    currentStartedAt = currentStartedAt
)

internal fun GamePlayerDto.toDomain(id: String) = GamePlayer(
    id = id,
    pseudo = pseudo,
    score = score,
    isHost = isHost,
    answeredIndex = answeredIndex,
    lastChoice = lastChoice
)
