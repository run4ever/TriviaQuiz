package com.fabien.trivia.ui.game

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val ColorCorrect = Color(0xFF4CAF50)
private val ColorWrong = Color(0xFFF44336)

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    state: GameState,
    onSelectAnswer: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onGoHome: () -> Unit
) {
    val question = state.questions[state.currentIndex]
    val isCorrect = state.selectedAnswerIndex == question.correctIndex

    Column(modifier = modifier.fillMaxSize()) {

        val tapInteractionSource = remember { MutableInteractionSource() }

        Column(
            modifier = Modifier
                .weight(1f)
                // Réponse confirmée : un tap n'importe où avance ; un glissement scrolle l'explication.
                .then(
                    if (state.answerConfirmed) {
                        Modifier.clickable(
                            interactionSource = tapInteractionSource,
                            indication = null,
                            onClick = onNextQuestion
                        )
                    } else {
                        Modifier
                    }
                )
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            TextButton(onClick = onGoHome) {
                Text("< Accueil", style = MaterialTheme.typography.labelLarge)
            }

            Spacer(Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Text(
                    text = question.text,
                    modifier = Modifier.padding(20.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(Modifier.height(16.dp))

            question.options.forEachIndexed { index, option ->
                val isOptionCorrect = index == question.correctIndex
                val isSelected = index == state.selectedAnswerIndex

                val containerColor = when {
                    state.answerConfirmed && isOptionCorrect -> ColorCorrect
                    state.answerConfirmed && isSelected -> ColorWrong
                    state.answerConfirmed -> MaterialTheme.colorScheme.surfaceVariant
                    else -> MaterialTheme.colorScheme.primary
                }
                val contentColor = when {
                    state.answerConfirmed && (isOptionCorrect || isSelected) -> Color.White
                    state.answerConfirmed -> MaterialTheme.colorScheme.onSurfaceVariant
                    else -> MaterialTheme.colorScheme.onPrimary
                }

                // Une fois la réponse confirmée, les boutons restent actifs mais avancent
                // (sinon un bouton désactivé bloque le tap « continuer » du conteneur parent).
                Button(
                    onClick = {
                        if (state.answerConfirmed) onNextQuestion() else onSelectAnswer(index)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = containerColor,
                        contentColor = contentColor
                    )
                ) {
                    Text(option, style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(Modifier.height(8.dp))
            }

            if (state.answerConfirmed) {
                Spacer(Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isCorrect) ColorCorrect.copy(alpha = 0.12f)
                        else ColorWrong.copy(alpha = 0.12f)
                    )
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = if (isCorrect) "Bravo !" else "Dommage !",
                            style = MaterialTheme.typography.labelLarge,
                            color = if (isCorrect) ColorCorrect else ColorWrong
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = question.explanation,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        HorizontalDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                if (state.answerConfirmed && state.lastRatingDelta != 0) {
                    val delta = state.lastRatingDelta
                    Text(
                        text = if (delta > 0) "+$delta" else "$delta",
                        style = MaterialTheme.typography.labelMedium,
                        color = if (delta > 0) ColorCorrect else ColorWrong
                    )
                }
                Text(
                    text = "Niv. ${state.displayedRating}",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            if (state.answerConfirmed) {
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Touchez l'écran pour continuer",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(4.dp))
                    Button(onClick = onNextQuestion) {
                        Text("Question suivante", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
