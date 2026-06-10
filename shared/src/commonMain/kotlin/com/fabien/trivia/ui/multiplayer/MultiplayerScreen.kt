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
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon
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

// ── Écran 1 · Lancement (« Jouer à plusieurs ») — refonte Vitamine ──────────
@Composable
private fun EntryContent(
    state: MultiplayerUiState,
    onPseudo: (String) -> Unit,
    onCreate: () -> Unit,
    onJoin: () -> Unit,
    onExit: () -> Unit
) {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    Column(
        modifier = Modifier.fillMaxSize().background(TriviaPalette.bg).imePadding()
    ) {
        MHeader(title = "Jouer à plusieurs", backLabel = "Accueil", onBack = onExit)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Héros : tuile dégradée + sous-texte
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Brush.linearGradient(listOf(TriviaPalette.brand, Color(0xFF9B7DFF)))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(AppIcons.Users, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
                }
                Text(
                    text = "Affronte tes amis en temps réel — crée un salon ou rejoins une partie avec un code.",
                    style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 14.5.sp, color = TriviaPalette.inkSoft),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.widthIn(max = 280.dp)
                )
            }

            MField(label = "Pseudo", value = state.pseudo, onValueChange = onPseudo)

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                MChunkyButton(
                    text = "Créer une partie",
                    icon = AppIcons.Users,
                    onClick = onCreate,
                    enabled = !state.isBusy,
                    modifier = Modifier.fillMaxWidth()
                )
                MContourButton(
                    text = "Rejoindre une partie",
                    icon = AppIcons.ChevronRight,
                    onClick = onJoin,
                    enabled = !state.isBusy,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            ErrorAndBusy(state)
        }
    }
}

// ── Écran 2 · Créer une partie — refonte Vitamine ──────────────────────────
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

    val countOptions = listOf<Int?>(null, 20, 40, 60)
    val countLabels = listOf("Illimité", "20", "40", "60")

    Column(modifier = Modifier.fillMaxSize().background(TriviaPalette.bg).imePadding()) {
        MHeader(title = "Créer une partie", backLabel = "Retour", onBack = onBack)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, top = 14.dp, bottom = 22.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            MField(label = "Pseudo", value = state.pseudo, onValueChange = onPseudo)

            Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                MLabel("Score")
                MSeg(
                    options = listOf("Simple", "Rapidité"),
                    selectedIndex = if (scoring == ScoringMode.SIMPLE) 0 else 1,
                    onSelect = { scoring = if (it == 0) ScoringMode.SIMPLE else ScoringMode.RAPIDITE }
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                MLabel("Nombre de questions")
                MSeg(
                    options = countLabels,
                    selectedIndex = countOptions.indexOf(count).coerceAtLeast(0),
                    onSelect = { count = countOptions[it] }
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                MLabel("Catégorie")
                MCatRow(
                    name = "Toutes catégories",
                    icon = AppIcons.Sparkle,
                    isAll = true,
                    selected = category == null,
                    onClick = { category = null }
                )
                Category.entries.forEach { cat ->
                    MCatRow(
                        name = cat.displayName,
                        icon = categoryIcon(cat),
                        tileColor = catColors(cat).main,
                        selected = category == cat,
                        onClick = { category = cat }
                    )
                }
            }

            MChunkyButton(
                text = "Créer la partie",
                icon = AppIcons.Play,
                onClick = { onCreate(scoring, count, category) },
                enabled = !state.isBusy,
                modifier = Modifier.fillMaxWidth()
            )

            ErrorAndBusy(state)
        }
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

// ── Écran 3 · Salon (code à partager) — refonte Vitamine ───────────────────
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun LobbyContent(
    state: MultiplayerUiState,
    onStart: () -> Unit,
    onLeave: () -> Unit
) {
    val room = state.room ?: return
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily

    val chips = listOf(
        room.category?.displayName ?: "Toutes catégories",
        room.questionCount?.let { "$it questions" } ?: "Partie illimitée",
        "Score " + if (room.scoringMode == ScoringMode.RAPIDITE) "Rapidité" else "Simple"
    )

    Column(modifier = Modifier.fillMaxSize().background(TriviaPalette.bg)) {
        MHeader(title = "Salon", backLabel = "Retour", onBack = onLeave)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, top = 18.dp, bottom = 22.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            SalonCodeCard(room.code)

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                chips.forEach { ParamChip(it) }
            }

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Joueurs", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp, color = TriviaPalette.ink))
                    Spacer(Modifier.size(6.dp))
                    Text("(${state.players.size})", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp, color = TriviaPalette.inkFaint))
                }
                state.players.forEach { LobbyPlayerRow(it.pseudo, it.isHost) }
                LobbyWaitingSlot()
            }

            if (state.isHost) {
                MChunkyButton(
                    text = "Démarrer la partie",
                    icon = AppIcons.Play,
                    onClick = onStart,
                    enabled = !state.isBusy && state.players.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Text(
                    text = "En attente que l'hôte démarre…",
                    style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = TriviaPalette.inkSoft),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                )
            }

            ErrorAndBusy(state)
        }
    }
}

/** Carte « code de la partie » (dégradé lilas) + bouton qui copie le code dans le presse-papiers. */
@Composable
private fun SalonCodeCard(code: String) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val clipboard = LocalClipboardManager.current
    var copied by remember { mutableStateOf(false) }
    LaunchedEffect(copied) { if (copied) { delay(1500); copied = false } }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(Brush.linearGradient(listOf(Color(0xFFEFE9FF), Color(0xFFF7F3FF))))
            .border(1.5.dp, Color(0xFFE4DBFF), RoundedCornerShape(22.dp))
            .padding(horizontal = 18.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "CODE DE LA PARTIE",
            style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 13.sp, letterSpacing = 0.5.sp, color = TriviaPalette.brandDeep)
        )
        Text(
            code,
            style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 52.sp, letterSpacing = 8.sp, color = TriviaPalette.brand),
            modifier = Modifier.padding(top = 4.dp)
        )
        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .height(42.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(TriviaPalette.brand)
                .clickable {
                    clipboard.setText(AnnotatedString(code))
                    copied = true
                }
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(if (copied) AppIcons.Check else AppIcons.Share, contentDescription = null, tint = Color.White, modifier = Modifier.size(17.dp))
            Text(
                if (copied) "Code copié !" else "Partager le code",
                style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
            )
        }
    }
}

/** Petite étiquette de paramètre de partie (chip blanc bordé). */
@Composable
private fun ParamChip(text: String) {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    Text(
        text,
        style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 12.5.sp, color = TriviaPalette.inkSoft),
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(TriviaPalette.card)
            .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    )
}

/** Ligne joueur du salon : avatar dégradé + pseudo + badge « Hôte » doré. */
@Composable
private fun LobbyPlayerRow(pseudo: String, isHost: Boolean) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val initial = pseudo.firstOrNull()?.uppercaseChar()?.toString() ?: "?"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(TriviaPalette.card)
            .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(16.dp))
            .padding(horizontal = 14.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Brush.linearGradient(listOf(TriviaPalette.brand, Color(0xFFEC4899)))),
            contentAlignment = Alignment.Center
        ) {
            Text(initial, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 17.sp, color = Color.White))
        }
        Text(
            pseudo,
            style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 17.sp, color = TriviaPalette.ink),
            modifier = Modifier.weight(1f)
        )
        if (isHost) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFFDF3D6))
                    .padding(horizontal = 11.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(AppIcons.Crown, contentDescription = null, tint = TriviaPalette.gold, modifier = Modifier.size(13.dp))
                Text("Hôte", style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 12.sp, color = TriviaPalette.gold))
            }
        }
    }
}

/** Emplacement vide « En attente d'autres joueurs… » (bordure pointillée). */
@Composable
private fun LobbyWaitingSlot() {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val line = TriviaPalette.line
    val dash = remember { PathEffect.dashPathEffect(floatArrayOf(10f, 8f)) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = line,
                    style = Stroke(width = 1.5.dp.toPx(), pathEffect = dash),
                    cornerRadius = CornerRadius(16.dp.toPx())
                )
            }
            .padding(horizontal = 14.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(AppIcons.Users, contentDescription = null, tint = TriviaPalette.inkFaint, modifier = Modifier.size(18.dp))
        }
        Text(
            "En attente d'autres joueurs…",
            style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 14.5.sp, color = TriviaPalette.inkFaint)
        )
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
