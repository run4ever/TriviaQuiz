package com.fabien.trivia.ui.game

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.components.Confetti
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.CatColors
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon

private val ConfettiPalette = listOf(
    TriviaPalette.good, TriviaPalette.gold, TriviaPalette.brand,
    Color(0xFFEC4899), Color(0xFF3B82F6),
)

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    state: GameState,
    onSelectAnswer: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onGoHome: () -> Unit
) {
    val question = state.questions[state.currentIndex]
    val cat = catColors(question.category)
    val reveal = state.answerConfirmed
    val isCorrect = state.selectedAnswerIndex == question.correctIndex

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
    ) {
        GameHeader(
            cat = cat,
            categoryIcon = categoryIcon(question.category),
            correctStreak = state.correctStreak,
            rating = state.displayedRating,
            onClose = onGoHome
        )

        // Zone scrollable : un tap n'importe où avance une fois la réponse confirmée (comme avant).
        val tapInteraction = remember { MutableInteractionSource() }
        Column(
            modifier = Modifier
                .weight(1f)
                .then(
                    if (reveal) Modifier.clickable(
                        interactionSource = tapInteraction,
                        indication = null,
                        onClick = onNextQuestion
                    ) else Modifier
                )
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(Modifier.height(16.dp))
            // Carte question (espace au-dessus, sous l'en-tête coloré).
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(TriviaPalette.card)
                    .padding(20.dp)
            ) {
                Text(
                    text = question.text,
                    style = MaterialTheme.typography.titleLarge,
                    color = TriviaPalette.ink
                )
            }

            question.options.forEachIndexed { index, option ->
                AnswerCard(
                    letter = "ABCD".getOrElse(index) { '?' }.toString(),
                    text = option,
                    cat = cat,
                    reveal = reveal,
                    isCorrect = index == question.correctIndex,
                    isPicked = index == state.selectedAnswerIndex,
                    onClick = { if (!reveal) onSelectAnswer(index) else onNextQuestion() }
                )
                Spacer(Modifier.height(11.dp))
            }
            Spacer(Modifier.height(8.dp))
        }

        if (reveal) {
            FeedbackBanner(
                isCorrect = isCorrect,
                delta = state.lastRatingDelta,
                explanation = question.explanation,
                cat = cat,
                onContinue = onNextQuestion
            )
        }
    }
}

@Composable
private fun GameHeader(
    cat: CatColors,
    categoryIcon: ImageVector,
    correctStreak: Int,
    rating: Int,
    onClose: () -> Unit
) {
    // Tout sur une seule ligne : flamme (série, toujours visible, 0 après une erreur) / niveau (couronne
    // + valeur, sans libellé de rang) / catégorie (icône seule) / fermer (poussé à droite).
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(cat.main)
            .padding(start = 18.dp, end = 18.dp, top = 12.dp, bottom = 22.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        HeaderPill {
            Icon(AppIcons.Flame, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
            Text("$correctStreak", style = MaterialTheme.typography.titleMedium, color = Color.White)
        }
        HeaderPill {
            Icon(AppIcons.Crown, contentDescription = null, tint = Color.White, modifier = Modifier.size(17.dp))
            Text("$rating", style = MaterialTheme.typography.titleSmall, color = Color.White)
        }
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White.copy(alpha = 0.18f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(categoryIcon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
        }
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White.copy(alpha = 0.18f))
                .clickable(onClick = onClose),
            contentAlignment = Alignment.Center
        ) {
            Icon(AppIcons.Close, contentDescription = "Fermer", tint = Color.White, modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
private fun HeaderPill(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White.copy(alpha = 0.18f))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) { content() }
}

@Composable
private fun AnswerCard(
    letter: String,
    text: String,
    cat: CatColors,
    reveal: Boolean,
    isCorrect: Boolean,
    isPicked: Boolean,
    onClick: () -> Unit
) {
    val good = TriviaPalette.good
    val bad = TriviaPalette.bad
    val showCorrect = reveal && isCorrect
    val showWrong = reveal && isPicked && !isCorrect

    val targetBg = when {
        showCorrect -> TriviaPalette.goodTint
        showWrong -> TriviaPalette.badTint
        else -> TriviaPalette.card
    }
    val bg by animateColorAsState(targetBg, tween(280))
    val borderColor = when {
        showCorrect -> good
        showWrong -> bad
        else -> TriviaPalette.line
    }
    val badgeBg = when {
        showCorrect -> good
        showWrong -> bad
        else -> cat.tint
    }
    val badgeFg = if (showCorrect || showWrong) Color.White else cat.deep
    val textColor = when {
        showWrong -> Color(0xFFB42121)
        else -> TriviaPalette.ink
    }

    // Pop (rebond) sur la bonne réponse, shake (oscillation X) sur la mauvaise choisie.
    val pop by animateFloatAsState(
        if (showCorrect) 1.04f else 1f,
        spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )
    val shake = remember { Animatable(0f) }
    LaunchedEffect(reveal) {
        if (showWrong) {
            shake.snapTo(0f)
            shake.animateTo(0f, keyframes {
                durationMillis = 400
                -7f at 80
                6f at 160
                -4f at 240
                0f at 400
            })
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .scale(pop)
            .offset(x = shake.value.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(bg)
            .border(2.dp, borderColor, RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 15.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(11.dp))
                .background(badgeBg),
            contentAlignment = Alignment.Center
        ) {
            when {
                showCorrect -> Icon(AppIcons.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                showWrong -> Icon(AppIcons.Close, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                else -> Text(letter, style = MaterialTheme.typography.titleMedium, color = badgeFg)
            }
        }
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = textColor,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun FeedbackBanner(
    isCorrect: Boolean,
    delta: Int,
    explanation: String,
    cat: CatColors,
    onContinue: () -> Unit
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(if (isCorrect) TriviaPalette.goodTint else TriviaPalette.badTint)
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(50))
                        .background(if (isCorrect) TriviaPalette.good else TriviaPalette.bad),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        if (isCorrect) AppIcons.Check else AppIcons.Close,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(Modifier.size(9.dp))
                Text(
                    text = if (isCorrect) "Bravo !" else "Raté…",
                    style = MaterialTheme.typography.titleLarge,
                    color = if (isCorrect) TriviaPalette.good else Color(0xFFB42121),
                    modifier = Modifier.weight(1f)
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(TriviaPalette.card)
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        AppIcons.Bolt,
                        contentDescription = null,
                        tint = if (isCorrect) TriviaPalette.good else TriviaPalette.bad,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = if (delta >= 0) "+$delta" else "$delta",
                        style = MaterialTheme.typography.titleSmall,
                        color = if (isCorrect) TriviaPalette.good else TriviaPalette.bad
                    )
                }
            }

            Spacer(Modifier.height(8.dp))
            Text(
                text = explanation,
                style = MaterialTheme.typography.bodyMedium,
                color = TriviaPalette.inkSoft
            )
            Spacer(Modifier.height(14.dp))
            ChunkyButton(
                onClick = onContinue,
                color = cat.main,
                deep = cat.deep,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Continuer", style = MaterialTheme.typography.titleMedium, color = Color.White)
                Spacer(Modifier.weight(1f))
                Icon(AppIcons.ChevronRight, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            }
        }

        if (isCorrect) {
            Confetti(palette = ConfettiPalette, modifier = Modifier.matchParentSize())
        }
    }
}
