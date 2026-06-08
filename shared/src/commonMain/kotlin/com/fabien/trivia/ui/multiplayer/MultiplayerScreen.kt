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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.displayName
import com.fabien.trivia.data.multiplayer.GameStatus
import com.fabien.trivia.data.multiplayer.ScoringMode

/** Point d'entrée du multijoueur. Rend l'écran selon la phase du [MultiplayerViewModel]. */
@Composable
fun MultiplayerScreen(viewModel: MultiplayerViewModel, onExit: () -> Unit) {
    val state by viewModel.state.collectAsState()
    when (state.phase) {
        MpPhase.ENTRY -> EntryContent(state, viewModel::setPseudo, viewModel::goToCreate, viewModel::goToJoin, onExit)
        MpPhase.CREATE -> CreateContent(state, viewModel::setPseudo, viewModel::createGame, viewModel::backToEntry)
        MpPhase.JOIN -> JoinContent(state, viewModel::setPseudo, viewModel::joinGame, viewModel::backToEntry)
        MpPhase.LOBBY -> LobbyContent(state, viewModel::startGame, viewModel::leaveGame)
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
            ChoiceButton("Ouverte", count == null, Modifier.weight(1f)) { count = null }
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
    val room = state.room
    // Avant le démarrage : simple « Retour ». Une fois la partie lancée : « Quitter ».
    val started = room?.status == GameStatus.PLAYING
    val backLabel = if (started) "Quitter" else "< Retour"
    ScreenScaffold(title = "Salon", onBack = onLeave, backLabel = backLabel) {
        if (room == null) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            return@ScreenScaffold
        }

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
        val countLabel = room.questionCount?.let { "$it questions" } ?: "partie ouverte"
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
        when {
            room.status == GameStatus.PLAYING -> Text(
                text = "La partie démarre… (déroulé à venir — étape 2)",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            state.isHost -> Button(
                onClick = onStart,
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isBusy && state.players.size >= 1
            ) {
                Text("Démarrer la partie")
            }
            else -> Text(
                text = "En attente que l'hôte démarre…",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        ErrorAndBusy(state)
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
