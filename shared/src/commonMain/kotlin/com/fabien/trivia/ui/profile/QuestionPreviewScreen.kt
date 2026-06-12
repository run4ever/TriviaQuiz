package com.fabien.trivia.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fabien.trivia.data.Question
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.game.AnswerCard
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon

/**
 * Relecture d'UNE question depuis l'historique (H3). Présentation façon « mode solo » (énoncé + options +
 * révélation de la bonne réponse + explication), mais : (1) **pas d'enchaînement** — après la réponse, la
 * SEULE issue est « Quitter » (qui ramène à l'historique) ; (2) neutre côté ELO/séries — [onAnswered] est
 * invoqué une fois pour que le `GameViewModel` retire éventuellement la question du pool de révision.
 */
@Composable
fun QuestionPreviewScreen(
    modifier: Modifier = Modifier,
    question: Question,
    onAnswered: (correct: Boolean) -> Unit,
    onQuit: () -> Unit,
) {
    val cat = catColors(question.category)
    var selected by remember(question.id) { mutableStateOf<Int?>(null) }
    val reveal = selected != null
    val isCorrect = selected == question.correctIndex

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
    ) {
        // En-tête : bouton « Quitter » (toujours présent) + icône catégorie.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(cat.main)
                .padding(start = 10.dp, end = 18.dp, top = 10.dp, bottom = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable(onClick = onQuit)
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(AppIcons.ChevronLeft, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                Text("Quitter", style = MaterialTheme.typography.titleSmall, color = Color.White)
            }
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White.copy(alpha = 0.18f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(categoryIcon(question.category), contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(TriviaPalette.card)
                    .padding(20.dp)
            ) {
                Text(question.text, style = MaterialTheme.typography.titleLarge, color = TriviaPalette.ink)
            }

            question.options.forEachIndexed { index, option ->
                Spacer(Modifier.height(11.dp))
                AnswerCard(
                    letter = "ABCD".getOrElse(index) { '?' }.toString(),
                    text = option,
                    cat = cat,
                    reveal = reveal,
                    isCorrect = index == question.correctIndex,
                    isPicked = index == selected,
                    // Avant réponse : on sélectionne et on notifie une seule fois. Après : plus rien (pas d'enchaînement).
                    onClick = {
                        if (!reveal) {
                            selected = index
                            onAnswered(index == question.correctIndex)
                        }
                    }
                )
            }

            if (reveal) {
                Spacer(Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .background(if (isCorrect) TriviaPalette.goodTint else TriviaPalette.badTint)
                        .padding(16.dp)
                ) {
                    Text(
                        text = if (isCorrect) "Bonne réponse" else "Mauvaise réponse",
                        style = MaterialTheme.typography.titleMedium,
                        color = if (isCorrect) TriviaPalette.good else Color(0xFFB42121)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(question.explanation, style = MaterialTheme.typography.bodyMedium, color = TriviaPalette.inkSoft)
                }
                Spacer(Modifier.height(14.dp))
                ChunkyButton(
                    onClick = onQuit,
                    color = cat.main,
                    deep = cat.deep,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Quitter", style = MaterialTheme.typography.titleMedium, color = Color.White)
                    Spacer(Modifier.weight(1f))
                    Icon(AppIcons.ChevronRight, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                }
            }
            Spacer(Modifier.height(20.dp))
        }
    }
}
