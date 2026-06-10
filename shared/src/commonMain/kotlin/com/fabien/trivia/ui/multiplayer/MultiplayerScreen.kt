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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.CircleShape
import com.fabien.trivia.ui.components.Confetti
import com.fabien.trivia.ui.components.ProgressRing
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
import androidx.compose.ui.graphics.vector.ImageVector
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

// ── Écran « Rejoindre une partie » (saisie du code) — refonte Vitamine ─────
@Composable
private fun JoinContent(
    state: MultiplayerUiState,
    onPseudo: (String) -> Unit,
    onJoin: (String) -> Unit,
    onBack: () -> Unit
) {
    var code by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(TriviaPalette.bg).imePadding()) {
        MHeader(title = "Rejoindre une partie", backLabel = "Retour", onBack = onBack)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, top = 14.dp, bottom = 22.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            MField(label = "Pseudo", value = state.pseudo, onValueChange = onPseudo)
            MCodeField(value = code, onValueChange = { code = it })
            MChunkyButton(
                text = "Rejoindre",
                icon = AppIcons.Play,
                onClick = { onJoin(code) },
                enabled = !state.isBusy && code.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            ErrorAndBusy(state)
        }
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

// ── Écrans 4-6 · Partie (question / faux / bon) — refonte Vitamine ──────────
@Composable
private fun GameContent(
    state: MultiplayerUiState,
    onAnswer: (Int) -> Unit,
    onEndGame: () -> Unit,
    onLeave: () -> Unit
) {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val round = state.round

    Column(modifier = Modifier.fillMaxSize().background(TriviaPalette.bg)) {
        if (round == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = TriviaPalette.brand)
            }
            return
        }

        val reveal = round.phase == RoundPhase.REVEAL
        val unlimited = state.room?.questionCount == null
        val colors = catColors(round.question.category)
        val onHeader = Color.White
        val translucent = Color.White.copy(alpha = 0.18f)

        // En-tête coloré (couleur de la catégorie de la question)
        Column(modifier = Modifier.fillMaxWidth().background(colors.main).padding(start = 18.dp, end = 18.dp, top = 8.dp, bottom = 16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.clip(RoundedCornerShape(13.dp)).background(translucent).clickable(onClick = onLeave).padding(horizontal = 14.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(AppIcons.Close, contentDescription = null, tint = onHeader, modifier = Modifier.size(17.dp))
                    Text("Quitter", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = onHeader))
                }
                Row(
                    modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(translucent).padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Icon(categoryIcon(round.question.category), contentDescription = null, tint = onHeader, modifier = Modifier.size(15.dp))
                    Text(round.question.category.displayName, style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 13.sp, color = onHeader), maxLines = 1)
                }
                if (!reveal) {
                    ProgressRing(
                        fraction = round.timerFraction,
                        ringSize = 40.dp,
                        stroke = 5.dp,
                        color = onHeader,
                        track = Color.White.copy(alpha = 0.22f)
                    ) {
                        Text("${ceil(round.remainingMs / 1000.0).toInt()}", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 13.sp, color = onHeader))
                    }
                } else {
                    Spacer(Modifier.size(40.dp))
                }
            }
            // Barre de progression + compteur (masqué en illimité)
            Spacer(Modifier.height(14.dp))
            if (!unlimited) {
                Box(modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)).background(Color.White.copy(alpha = 0.25f))) {
                    val pct = ((round.index + 1).toFloat() / round.total.coerceAtLeast(1)).coerceIn(0.04f, 1f)
                    Box(modifier = Modifier.fillMaxWidth(pct).fillMaxHeight().clip(RoundedCornerShape(3.dp)).background(onHeader))
                }
                Spacer(Modifier.height(7.dp))
                Text("Question ${round.index + 1} / ${round.total}", style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 12.sp, color = onHeader.copy(alpha = 0.9f)))
            } else {
                Text("Question ${round.index + 1}", style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 12.sp, color = onHeader.copy(alpha = 0.9f)))
            }
        }

        // Contenu scrollable : carte question + réponses + scores + action
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(start = 18.dp, end = 18.dp, top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Carte question
            Box(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(22.dp)).background(TriviaPalette.card).padding(horizontal = 20.dp, vertical = 18.dp)
            ) {
                Text(round.question.text, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = TriviaPalette.ink, lineHeight = 26.sp))
            }

            // Réponses (lettrées)
            round.question.options.forEachIndexed { index, option ->
                MAnswerRow(
                    letter = ('A' + index).toString(),
                    text = option,
                    isCorrect = index == round.question.correctIndex,
                    isMine = round.myChoice == index,
                    reveal = reveal,
                    catColors = colors,
                    enabled = round.phase == RoundPhase.ANSWERING && round.myChoice == null,
                    onClick = { onAnswer(index) }
                )
            }

            if (!reveal && round.myChoice != null) {
                Text(
                    text = "Réponse enregistrée — en attente des autres…",
                    style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = TriviaPalette.inkSoft),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                )
            }

            if (reveal) {
                MScores(state, round.index, round.question.correctIndex)
            }

            if (state.isHost) {
                MContourButton(
                    text = "Terminer la partie",
                    onClick = onEndGame,
                    enabled = !state.isBusy,
                    textColor = TriviaPalette.inkSoft,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            ErrorAndBusy(state)
        }
    }
}

/** Une réponse de l'écran de jeu : badge lettre (→ check/croix à la révélation) + libellé, couleurs animées. */
@Composable
private fun MAnswerRow(
    letter: String,
    text: String,
    isCorrect: Boolean,
    isMine: Boolean,
    reveal: Boolean,
    catColors: com.fabien.trivia.ui.theme.CatColors,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val correctChosen = reveal && isCorrect
    val wrongChosen = reveal && isMine && !isCorrect

    val targetBg = when {
        correctChosen -> TriviaPalette.goodTint
        wrongChosen -> TriviaPalette.badTint
        else -> TriviaPalette.card
    }
    val targetBorder = when {
        correctChosen -> TriviaPalette.good
        wrongChosen -> TriviaPalette.bad
        else -> TriviaPalette.line
    }
    val targetFg = when {
        correctChosen -> Color(0xFF15723A)
        wrongChosen -> Color(0xFFB42121)
        else -> TriviaPalette.ink
    }
    val targetBadgeBg = when {
        correctChosen -> TriviaPalette.good
        wrongChosen -> TriviaPalette.bad
        else -> catColors.main.copy(alpha = 0.11f)
    }
    val badgeFg = if (correctChosen || wrongChosen) Color.White else catColors.deep

    val bg by animateColorAsState(targetBg, label = "answBg")
    val border by animateColorAsState(targetBorder, label = "answBorder")
    val fg by animateColorAsState(targetFg, label = "answFg")
    val badgeBg by animateColorAsState(targetBadgeBg, label = "answBadge")

    val shape = RoundedCornerShape(16.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(bg)
            .border(2.dp, border, shape)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier.size(32.dp).clip(RoundedCornerShape(10.dp)).background(badgeBg),
            contentAlignment = Alignment.Center
        ) {
            when {
                correctChosen -> Icon(AppIcons.Check, contentDescription = null, tint = badgeFg, modifier = Modifier.size(19.dp))
                wrongChosen -> Icon(AppIcons.Close, contentDescription = null, tint = badgeFg, modifier = Modifier.size(17.dp))
                else -> Text(letter, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp, color = badgeFg))
            }
        }
        Text(text, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 16.5.sp, color = fg), modifier = Modifier.weight(1f))
    }
}

// Palette de couleurs de joueurs (avatars du panneau de scores / podium), attribuée par ordre stable.
private val PlayerColors = listOf(
    Color(0xFF7A5AF8), Color(0xFF0FA697), Color(0xFFEC4899),
    Color(0xFF1FA84B), Color(0xFF3B82F6), Color(0xFFE5890F)
)

private fun playerColorMap(players: List<GamePlayer>): Map<String, Color> =
    players.sortedBy { it.id }.mapIndexed { i, p -> p.id to PlayerColors[i % PlayerColors.size] }.toMap()

/** Panneau de scores (bas de l'écran de jeu) : pastille statut + avatar + pseudo + delta + total, rangs animés. */
@Composable
private fun MScores(state: MultiplayerUiState, currentIndex: Int, correctIndex: Int) {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val ranked = state.players.sortedByDescending { it.score }
    val colorOf = playerColorMap(state.players)
    val rowHeight = 50.dp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(TriviaPalette.card)
            .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(18.dp))
            .padding(horizontal = 16.dp, vertical = 13.dp)
    ) {
        Text(
            "SCORES",
            style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 11.sp, letterSpacing = 0.6.sp, color = TriviaPalette.inkFaint)
        )
        Spacer(Modifier.height(6.dp))
        Box(modifier = Modifier.fillMaxWidth().height(rowHeight * ranked.size.coerceAtLeast(1))) {
            // Ordre d'itération STABLE (par id) + key() : chaque ligne glisse vers son nouveau rang.
            state.players.sortedBy { it.id }.forEach { player ->
                key(player.id) {
                    val rank = ranked.indexOfFirst { it.id == player.id }.coerceAtLeast(0)
                    val offsetY by animateDpAsState(targetValue = rowHeight * rank, label = "rank")
                    MScoreRow(
                        player = player,
                        currentIndex = currentIndex,
                        correctIndex = correctIndex,
                        color = colorOf[player.id] ?: TriviaPalette.brand,
                        isMe = player.id == state.myId,
                        modifier = Modifier.fillMaxWidth().height(rowHeight).offset(y = offsetY)
                    )
                }
            }
        }
    }
}

@Composable
private fun MScoreRow(
    player: GamePlayer,
    currentIndex: Int,
    correctIndex: Int,
    color: Color,
    isMe: Boolean,
    modifier: Modifier
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val answeredThis = player.answeredIndex == currentIndex
    val gotItRight = answeredThis && player.lastChoice == correctIndex
    val initial = player.pseudo.firstOrNull()?.uppercaseChar()?.toString() ?: "?"
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(11.dp)) {
        // Pastille de statut
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(if (!answeredThis) Color(0xFFEDEAF2) else if (gotItRight) TriviaPalette.goodTint else TriviaPalette.badTint),
            contentAlignment = Alignment.Center
        ) {
            when {
                !answeredThis -> Box(Modifier.size(7.dp).clip(CircleShape).background(TriviaPalette.inkFaint))
                gotItRight -> Icon(AppIcons.Check, contentDescription = null, tint = TriviaPalette.good, modifier = Modifier.size(15.dp))
                else -> Icon(AppIcons.Close, contentDescription = null, tint = TriviaPalette.bad, modifier = Modifier.size(14.dp))
            }
        }
        // Avatar
        Box(
            modifier = Modifier.size(28.dp).clip(RoundedCornerShape(9.dp)).background(color),
            contentAlignment = Alignment.Center
        ) {
            Text(initial, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = Color.White))
        }
        // Pseudo (+ « · toi »)
        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
            Text(player.pseudo, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TriviaPalette.ink), maxLines = 1)
            if (isMe) {
                Text(" · toi", style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = TriviaPalette.inkFaint))
            }
        }
        // Delta
        if (answeredThis && player.lastPoints > 0) {
            Text("+${player.lastPoints}", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = TriviaPalette.good), modifier = Modifier.padding(end = 8.dp))
        }
        // Total
        Text("${player.score}", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp, color = TriviaPalette.ink))
    }
}

// ── Écran 7 · Résultats (podium festif, fond nuit) — refonte Vitamine ──────
private val ResultsNavy = Color(0xFF1B1733)
private val ResultsSubtle = Color(0xFFB6ACDF)

@Composable
private fun ResultsContent(state: MultiplayerUiState, onReplay: () -> Unit, onLeave: () -> Unit) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val ranked = state.players.sortedByDescending { it.score }
    val colorOf = playerColorMap(state.players)
    val winner = ranked.firstOrNull()?.pseudo

    Box(modifier = Modifier.fillMaxSize().background(ResultsNavy)) {
        // Halo radial violet en haut
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-70).dp)
                .size(320.dp)
                .background(Brush.radialGradient(listOf(Color(0x557A5AF8), Color(0x007A5AF8))))
        )
        // Confettis de célébration
        Confetti(
            palette = listOf(Color(0xFFF5B716), TriviaPalette.brand, Color(0xFFEC4899), Color(0xFF1FA84B), Color(0xFF3B82F6), Color(0xFF0FA697)),
            modifier = Modifier.fillMaxSize(),
            count = 40
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 20.dp)
        ) {
            // Lien Quitter
            Row(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).clickable(onClick = onLeave).padding(horizontal = 4.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(AppIcons.ChevronLeft, contentDescription = null, tint = ResultsSubtle, modifier = Modifier.size(18.dp))
                Spacer(Modifier.size(3.dp))
                Text("Quitter", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = ResultsSubtle))
            }

            // Trophée + titre
            Column(modifier = Modifier.fillMaxWidth().padding(top = 4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier.size(72.dp).clip(CircleShape).background(Brush.linearGradient(listOf(Color(0xFFF5B716), Color(0xFFE5890F)))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(AppIcons.Trophy, contentDescription = null, tint = Color.White, modifier = Modifier.size(38.dp))
                }
                Spacer(Modifier.height(10.dp))
                Text("Résultats", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 27.sp, color = Color.White))
                if (winner != null) {
                    Text("$winner remporte la partie 🎉", style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 13.5.sp, color = ResultsSubtle), modifier = Modifier.padding(top = 2.dp))
                }
            }

            Spacer(Modifier.height(26.dp))
            if (ranked.isNotEmpty()) ResultsPodium(ranked, colorOf)

            // Joueurs au-delà du podium (4e+)
            ranked.drop(3).forEachIndexed { i, player ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("${i + 4}. ${player.pseudo}", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.White), modifier = Modifier.weight(1f))
                    Text("${player.score} pts", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp, color = ResultsSubtle))
                }
            }

            Spacer(Modifier.height(24.dp))
            if (state.isHost) {
                MChunkyButton(text = "Rejouer", icon = AppIcons.Play, onClick = onReplay, enabled = !state.isBusy, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(11.dp))
                NightOutlineButton(text = "Revenir à l'accueil", icon = AppIcons.Home, onClick = onLeave)
            } else {
                Text(
                    text = "En attente de l'hôte (nouvelle partie ou fin)…",
                    style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = ResultsSubtle),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(14.dp))
                NightOutlineButton(text = "Quitter", icon = null, onClick = onLeave)
            }

            if (state.error != null) {
                Spacer(Modifier.height(14.dp))
                Text(state.error, style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFFFFB4AB)), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

/** Podium festif (2e à gauche, 1er au centre avec couronne, 3e à droite), aligné en bas. */
@Composable
private fun ResultsPodium(ranked: List<GamePlayer>, colorOf: Map<String, Color>) {
    val first = ranked.getOrNull(0)
    val second = ranked.getOrNull(1)
    val third = ranked.getOrNull(2)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        if (second != null) ResultsPodiumColumn(second, 2, 96.dp, colorOf[second.id] ?: TriviaPalette.brand, Modifier.weight(1f))
        if (first != null) ResultsPodiumColumn(first, 1, 150.dp, colorOf[first.id] ?: TriviaPalette.brand, Modifier.weight(1f))
        if (third != null) ResultsPodiumColumn(third, 3, 72.dp, colorOf[third.id] ?: TriviaPalette.brand, Modifier.weight(1f))
    }
}

@Composable
private fun ResultsPodiumColumn(player: GamePlayer, rank: Int, barHeight: Dp, color: Color, modifier: Modifier) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val initial = player.pseudo.firstOrNull()?.uppercaseChar()?.toString() ?: "?"
    val barGradient = when (rank) {
        1 -> listOf(Color(0xFFF5B716), Color(0xFFE5890F))      // or
        2 -> listOf(Color(0xFFC5CCD6), Color(0xFF9AA4B2))      // argent
        else -> listOf(Color(0xFFCDA879), Color(0xFFA67044))   // bronze
    }
    val avatarSize = if (rank == 1) 60.dp else 50.dp

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        if (rank == 1) {
            Icon(AppIcons.Crown, contentDescription = null, tint = Color(0xFFF5B716), modifier = Modifier.size(26.dp))
            Spacer(Modifier.height(2.dp))
        }
        Box(
            modifier = Modifier
                .size(avatarSize)
                .clip(CircleShape)
                .background(color)
                .border(3.dp, Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(initial, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = if (rank == 1) 25.sp else 21.sp, color = Color.White))
        }
        Spacer(Modifier.height(8.dp))
        Text(player.pseudo, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp, color = Color.White), maxLines = 1)
        Text("${player.score} pts", style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 12.5.sp, color = ResultsSubtle))
        Spacer(Modifier.height(9.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Brush.verticalGradient(barGradient)),
            contentAlignment = Alignment.TopCenter
        ) {
            Text("$rank", style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp, color = Color.White), modifier = Modifier.padding(top = 12.dp))
        }
    }
}

/** Bouton « contour clair » sur fond nuit (Revenir à l'accueil / Quitter). */
@Composable
private fun NightOutlineButton(text: String, icon: ImageVector?, onClick: () -> Unit) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color(0x1FFFFFFF))
            .border(2.dp, Color(0x33FFFFFF), RoundedCornerShape(18.dp))
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(19.dp))
            Spacer(Modifier.size(9.dp))
        }
        Text(text, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 16.5.sp, color = Color.White))
    }
}

// ---------- Helpers ----------

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
