package com.fabien.trivia.data.multiplayer

import com.fabien.trivia.data.Category
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Accès Firestore aux parties multijoueur (collection `games`, sous-collection `players`).
 * v1 orchestrée côté client : pas de Cloud Functions, l'état de partie vit dans les docs.
 * Les `observe*` exposent les snapshots temps réel sous forme de [Flow].
 */
class GameRoomRepository(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private val games get() = firestore.collection("games")
    private fun roomDoc(code: String) = games.document(code)
    private fun playersCol(code: String) = roomDoc(code).collection("players")

    suspend fun roomExists(code: String): Boolean = roomDoc(code).get().exists

    /** Génère un code à 4 caractères non encore utilisé (quelques essais, sinon best-effort). */
    suspend fun generateUniqueCode(): String {
        repeat(5) {
            val code = randomCode()
            if (!roomExists(code)) return code
        }
        return randomCode()
    }

    suspend fun createRoom(
        code: String,
        hostId: String,
        scoringMode: ScoringMode,
        questionCount: Int?,
        category: Category?,
        questionIds: List<String>,
        hostPseudo: String
    ) {
        roomDoc(code).set(
            GameRoomDto.serializer(),
            GameRoomDto(
                hostId = hostId,
                status = GameStatus.LOBBY.name,
                scoringMode = scoringMode.name,
                questionCount = questionCount,
                category = category?.name,
                questionIds = questionIds,
                currentIndex = 0
            )
        )
        upsertPlayer(code, hostId, hostPseudo, isHost = true)
    }

    suspend fun joinRoom(code: String, playerId: String, pseudo: String) {
        upsertPlayer(code, playerId, pseudo, isHost = false)
    }

    private suspend fun upsertPlayer(code: String, playerId: String, pseudo: String, isHost: Boolean) {
        playersCol(code).document(playerId).set(
            GamePlayerDto.serializer(),
            GamePlayerDto(pseudo = pseudo, score = 0, isHost = isHost)
        )
    }

    /** L'hôte lance la partie (passe le statut à PLAYING). Le déroulé est géré à l'étape 2. */
    suspend fun startGame(code: String) {
        roomDoc(code).set(RoomStatusDto.serializer(), RoomStatusDto(GameStatus.PLAYING.name), merge = true)
    }

    /**
     * Quitter la partie. Si l'hôte part (v1, pas de transfert d'hôte), la partie est supprimée :
     * les autres joueurs reçoivent la suppression via le listener et reviennent à l'accueil.
     */
    suspend fun leaveRoom(code: String, playerId: String, isHost: Boolean) {
        if (isHost) {
            playersCol(code).get().documents.forEach { it.reference.delete() }
            roomDoc(code).delete()
        } else {
            playersCol(code).document(playerId).delete()
        }
    }

    fun observeRoom(code: String): Flow<GameRoom?> =
        roomDoc(code).snapshots.map { snapshot ->
            if (snapshot.exists) snapshot.data(GameRoomDto.serializer()).toDomain(code) else null
        }

    fun observePlayers(code: String): Flow<List<GamePlayer>> =
        playersCol(code).snapshots.map { query ->
            query.documents.map { it.data(GamePlayerDto.serializer()).toDomain(it.id) }
        }
}

/** Caractères sans ambiguïté visuelle (pas de O/0, I/1). */
private const val CODE_CHARS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"

private fun randomCode(): String = (1..4).map { CODE_CHARS.random() }.joinToString("")
