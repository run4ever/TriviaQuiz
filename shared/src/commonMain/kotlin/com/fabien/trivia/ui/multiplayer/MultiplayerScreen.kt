package com.fabien.trivia.ui.multiplayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.key
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.displayName
import com.fabien.trivia.data.multiplayer.GamePlayer
import com.fabien.trivia.data.multiplayer.GameStatus
import com.fabien.trivia.data.multiplayer.ScoringMode
import kotlin.math.ceil

private val ColorCorrect = Color(0xFF4CAF50)
private val ColorWrong = Color(0xFFF44336)

/** Point d'entrée du multijoueur. Rend l'écran selon la phase du [MultiplayerViewModel]. */
@Composable
fun MultiplayerScreen(viewModel: MultiplayerViewModel, onExit: () -> Unit) {
    val state by viewModel.state.collectAsState()
    when (state.phase) {
        MpPhase.ENTRY -> EntryContent(state, viewModel::setPseudo, viewModel::goToCreate, viewModel::goToJoin, onExit)
        MpPhase.CREATE -> CreateContent(state, viewModel::setPseudo, viewModel::createGame, viewModel::backToEntry)
        MpPhase.JOIN -> JoinContent(state, viewModel::setPseudo, viewModel::joinGame, viewModel::backToEntry)
        MpPhase.LOBBY -> RoomContent(
            state = state,
            onStart = viewModel::startGame,
            onEndGame = viewModel::endGame,
            onAnswer = viewModel::submitAnswer,
            onReplay = viewModel::replay,
            onLeave = viewModel::leaveGame
        )
    }
}

/** Dans une partie : aiguille selon le statut (salon / en jeu / résultats). */
@Composable
private fun RoomContent(
    state: MultiplayerUiState,
    onStart: () -> Unit,
    onEndGame: () -> Unit,
    onAnswer: (Int) -> Unit,
    onReplay: () -> Unit,
    onLeave: () -> Unit
) {
    when (state.room?.status) {
        null, GameStatus.LOBBY -> LobbyContent(state, onStart, onLeave)
        GameStatus.PLAYING -> GameContent(state, onAnswer, onEndGame, onLeave)
        GameStatus.FINISHED -> ResultsContent(state, onReplay, onLeave)
    }
}

@Composable
private fun EntryContent(
    state: MultiplayerUiState,
    onPseudo: (String) -> Unit,
    onCreate: () -> Unit,
    onJoin: () -> Unit,
    onExit: () -> Unit
) {
    ScreenScaffold(title = "Jouer à plusieurs", onBack = onExit, backLabel = "< Accueil") {
        PseudoField(state.pseudo, onPseudo)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onCreate, modifier = Modifier.fillMaxWidth(), enabled = !state.isBusy) {
            Text("Créer une partie")
        }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onJoin, modifier = Modifier.fillMaxWidth(), enabled = !state.isBusy) {
            Text("Rejoindre une partie")
        }
        ErrorAndBusy(state)
    }
}

@Composable
private fun CreateContent(
    state: MultiplayerUiState,
    onPseudo: (String) -> Unit,
    onCreate: (ScoringMode, Int?, Category?) -> Unit,
    onBack: () -> Unit
) {
    var scoring by remember { mutableStateOf(ScoringMode.SIMPLE) }
    var count by remember { mutableStateOf<Int?>(20) }
    var category by remember { mutableStateOf<Category?>(null) }

    ScreenScaffold(title = "Créer une partie", onBack = onBack, backLabel = "< Retour") {
        PseudoField(state.pseudo, onPseudo)

        SectionLabel("Score")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChoiceButton("Simple", scoring == ScoringMode.SIMPLE, Modifier.weight(1f)) { scoring = ScoringMode.SIMPLE }
            ChoiceButton("Rapidité", scoring == ScoringMode.RAPIDITE, Modifier.weight(1f)) { scoring = ScoringMode.RAPIDITE }
        }

        SectionLabel("Nombre de questions")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChoiceButton("Illimité", count == null, Modifier.weight(1f)) { count = null }
            ChoiceButton("20", count == 20, Modifier.weight(1f)) { count = 20 }
            ChoiceButton("40", count == 40, Modifier.weight(1f)) { count = 40 }
            ChoiceButton("60", count == 60, Modifier.weight(1f)) { count = 60 }
        }

        SectionLabel("Catégorie")
        ChoiceButton("Toutes catégories", category == null, Modifier.fillMaxWidth()) { category = null }
        Category.entries.forEach { cat ->
            Spacer(Modifier.height(8.dp))
            ChoiceButton(cat.displayName, category == cat, Modifier.fillMaxWidth()) { category = cat }
        }

        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { onCreate(scoring, count, category) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !state.isBusy
        ) {
            Text("Créer la partie")
        }
        ErrorAndBusy(state)
    }
}

@Composable
private fun JoinContent(
    state: MultiplayerUiState,
    onPseudo: (String) -> Unit,
    onJoin: (String) -> Unit,
    onBack: () -> Unit
) {
    var code by remember { mutableStateOf("") }

    ScreenScaffold(title = "Rejoindre une partie", onBack = onBack, backLabel = "< Retour") {
        PseudoField(state.pseudo, onPseudo)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = code,
            onValueChange = { if (it.length <= 4) code = it.uppercase() },
            label = { Text("Code de la partie") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { onJoin(code) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !state.isBusy && code.isNotBlank()
        ) {
            Text("Rejoindre")
        }
        ErrorAndBusy(state)
    }
}

@Composable
private fun LobbyContent(
    state: MultiplayerUiState,
    onStart: () -> Unit,
    onLeave: () -> Unit
) {
    val room = state.room ?: return
    ScreenScaffold(title = "Salon", onBack = onLeave, backLabel = "< Retour") {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(
                modifier = Modifier.padding(20.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Code de la partie",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = room.code,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(Modifier.height(8.dp))
        val countLabel = room.questionCount?.let { "$it questions" } ?: "partie illimitée"
        val categoryLabel = room.category?.displayName ?: "Toutes catégories"
        val scoringLabel = if (room.scoringMode == ScoringMode.RAPIDITE) "Rapidité" else "Simple"
        Text(
            text = "$categoryLabel · $countLabel · score $scoringLabel",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        SectionLabel("Joueurs (${state.players.size})")
        state.players.forEach { player ->
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                Text(player.pseudo, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                if (player.isHost) {
                    Text("Hôte", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        if (state.isHost) {
            Button(
                onClick = onStart,
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isBusy && state.players.isNotEmpty()
            ) {
                Text("Démarrer la partie")
            }
        } else {
            Text(
                text = "En attente que l'hôte démarre…",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        ErrorAndBusy(state)
    }
}

@Composable
private fun GameContent(
    state: MultiplayerUiState,
    onAnswer: (Int) -> Unit,
    onEndGame: () -> Unit,
    onLeave: () -> Unit
) {
    ScreenScaffold(title = "Partie", onBack = onLeave, backLabel = "Quitter") {
        val round = state.round
        if (round == null) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            return@ScreenScaffold
        }

        val reveal = round.phase == RoundPhase.REVEAL
        // En mode illimité (questionCount null), le total n'a pas de sens → on masque le compteur.
        val unlimited = state.room?.questionCount == null
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            if (unlimited) {
                Spacer(Modifier.weight(1f))
            } else {
                Text(
                    text = "Question ${round.index + 1} / ${round.total}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.weight(1f)
                )
            }
            if (!reveal) {
                val seconds = ceil(round.remainingMs / 1000.0).toInt()
                Text("⏱ $seconds s", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
            }
        }

        Spacer(Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = round.question.text,
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Spacer(Modifier.height(16.dp))
        round.question.options.forEachIndexed { index, option ->
            val isCorrect = index == round.question.correctIndex
            val isMine = round.myChoice == index
            val container = when {
                reveal && isCorrect -> ColorCorrect
                reveal && isMine -> ColorWrong
                isMine -> MaterialTheme.colorScheme.tertiary
                else -> MaterialTheme.colorScheme.primary
            }
            val content = when {
                reveal && (isCorrect || isMine) -> Color.White
                isMine -> MaterialTheme.colorScheme.onTertiary
                else -> MaterialTheme.colorScheme.onPrimary
            }
            Button(
                onClick = { onAnswer(index) },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                enabled = round.phase == RoundPhase.ANSWERING && round.myChoice == null,
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = container,
                    contentColor = content,
                    disabledContainerColor = container,
                    disabledContentColor = content
                )
            ) {
                Text(option, style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.height(8.dp))
        }

        if (!reveal && round.myChoice != null) {
            Text(
                text = "Réponse enregistrée — en attente des autres…",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        if (reveal) {
            Scoreboard(state, round.index, round.question.correctIndex)
        }

        if (state.isHost) {
            Spacer(Modifier.height(16.dp))
            OutlinedButton(onClick = onEndGame, modifier = Modifier.fillMaxWidth(), enabled = !state.isBusy) {
                Text("Terminer la partie")
            }
        }
        ErrorAndBusy(state)
    }
}

@Composable
private fun Scoreboard(state: MultiplayerUiState, currentIndex: Int, correctIndex: Int) {
    SectionLabel("Scores")
    val ranked = state.players.sortedByDescending { it.score }
    val rowHeight = 44.dp
    Box(modifier = Modifier.fillMaxWidth().height(rowHeight * ranked.size.coerceAtLeast(1))) {
        // Ordre d'itération STABLE (par id) + key() : chaque ligne garde son identité et
        // glisse vers sa nouvelle position quand son rang change (remontée visible).
        state.players.sortedBy { it.id }.forEach { player ->
            key(player.id) {
                val rank = ranked.indexOfFirst { it.id == player.id }.coerceAtLeast(0)
                val offsetY by animateDpAsState(targetValue = rowHeight * rank, label = "rank")
                ScoreRow(
                    player = player,
                    currentIndex = currentIndex,
                    correctIndex = correctIndex,
                    modifier = Modifier.fillMaxWidth().height(rowHeight).offset(y = offsetY)
                )
            }
        }
    }

    // ⚠️ DEBUG TEMPORAIRE — à retirer. Montre les valeurs brutes lues depuis Firestore pour
    // chaque joueur, pour diagnostiquer pourquoi le « +points » ne s'affiche pas chez les autres.
    Spacer(Modifier.height(12.dp))
    Text(
        text = "DEBUG  currentIndex=$currentIndex  correctIndex=$correctIndex",
        style = MaterialTheme.typography.labelSmall,
        color = ColorWrong
    )
    state.players.sortedBy { it.id }.forEach { p ->
        val answeredThis = p.answeredIndex == currentIndex
        Text(
            text = "• ${p.pseudo}: answeredIndex=${p.answeredIndex} lastChoice=${p.lastChoice} " +
                "lastPoints=${p.lastPoints} score=${p.score} → answeredThis=$answeredThis",
            style = MaterialTheme.typography.labelSmall,
            color = ColorWrong
        )
    }
}

@Composable
private fun ScoreRow(player: GamePlayer, currentIndex: Int, correctIndex: Int, modifier: Modifier) {
    val answeredThis = player.answeredIndex == currentIndex
    val gotItRight = answeredThis && player.lastChoice == correctIndex
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = (if (answeredThis) (if (gotItRight) "✓ " else "✗ ") else "") + player.pseudo,
            style = MaterialTheme.typography.bodyLarge,
            color = if (gotItRight) ColorCorrect else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f)
        )
        if (answeredThis && player.lastPoints > 0) {
            Text(
                text = "+${player.lastPoints}",
                style = MaterialTheme.typography.labelLarge,
                color = ColorCorrect,
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Text("${player.score}", style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
private fun ResultsContent(state: MultiplayerUiState, onReplay: () -> Unit, onLeave: () -> Unit) {
    ScreenScaffold(title = "Résultats", onBack = onLeave, backLabel = "< Quitter") {
        val ranked = state.players.sortedByDescending { it.score }

        if (ranked.isNotEmpty()) Podium(ranked)

        // Les joueurs au-delà du podium, en liste.
        ranked.drop(3).forEachIndexed { i, player ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${i + 4}. ${player.pseudo}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                Text("${player.score} pts", style = MaterialTheme.typography.titleMedium)
            }
        }

        Spacer(Modifier.height(24.dp))
        if (state.isHost) {
            Button(onClick = onReplay, modifier = Modifier.fillMaxWidth(), enabled = !state.isBusy) {
                Text("Rejouer")
            }
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = onLeave, modifier = Modifier.fillMaxWidth()) {
                Text("Revenir à l'accueil")
            }
        } else {
            Text(
                text = "En attente de l'hôte (nouvelle partie ou fin)…",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            OutlinedButton(onClick = onLeave, modifier = Modifier.fillMaxWidth()) {
                Text("Quitter")
            }
        }
        ErrorAndBusy(state)
    }
}

@Composable
private fun Podium(ranked: List<GamePlayer>) {
    val first = ranked.getOrNull(0)
    val second = ranked.getOrNull(1)
    val third = ranked.getOrNull(2)
    Spacer(Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        // Disposition classique : 2e à gauche, 1er au centre (plus haut), 3e à droite.
        if (second != null) PodiumColumn(second, 2, 96.dp, Modifier.weight(1f))
        if (first != null) PodiumColumn(first, 1, 128.dp, Modifier.weight(1f))
        if (third != null) PodiumColumn(third, 3, 72.dp, Modifier.weight(1f))
    }
    Spacer(Modifier.height(16.dp))
}

@Composable
private fun PodiumColumn(player: GamePlayer, rank: Int, barHeight: Dp, modifier: Modifier) {
    val barColor = when (rank) {
        1 -> Color(0xFFFFD54F) // or
        2 -> Color(0xFFB0BEC5) // argent
        else -> Color(0xFFBCAAA4) // bronze
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = player.pseudo,
            style = MaterialTheme.typography.labelLarge,
            maxLines = 1
        )
        Text(
            text = "${player.score} pts",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
                .background(barColor, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("$rank", style = MaterialTheme.typography.headlineMedium, color = Color(0xFF333333))
        }
    }
}

// ---------- Helpers ----------

@Composable
private fun ScreenScaffold(
    title: String,
    onBack: () -> Unit,
    backLabel: String,
    content: @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)
    ) {
        TextButton(onClick = onBack) { Text(backLabel, style = MaterialTheme.typography.labelLarge) }
        Spacer(Modifier.height(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(24.dp))
        content()
    }
}

@Composable
private fun PseudoField(pseudo: String, onPseudo: (String) -> Unit) {
    OutlinedTextField(
        value = pseudo,
        onValueChange = onPseudo,
        label = { Text("Pseudo") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun SectionLabel(text: String) {
    Spacer(Modifier.height(20.dp))
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun ChoiceButton(text: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    if (selected) {
        FilledTonalButton(onClick = onClick, modifier = modifier) { Text(text) }
    } else {
        OutlinedButton(onClick = onClick, modifier = modifier) { Text(text) }
    }
}

@Composable
private fun androidx.compose.foundation.layout.ColumnScope.ErrorAndBusy(state: MultiplayerUiState) {
    if (state.error != null) {
        Spacer(Modifier.height(16.dp))
        Text(state.error, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
    }
    if (state.isBusy) {
        Spacer(Modifier.height(16.dp))
        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}
