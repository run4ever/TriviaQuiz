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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabien.trivia.data.displayName
import com.fabien.trivia.ui.game.CategoryHistory
import com.fabien.trivia.ui.game.QuestionHistoryItem
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.CatColors
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon
import kotlinx.datetime.LocalDate

private val HISTORY_MONTHS_FR = listOf(
    "janv.", "févr.", "mars", "avril", "mai", "juin",
    "juil.", "août", "sept.", "oct.", "nov.", "déc."
)

private fun formatHistoryDate(d: LocalDate): String =
    "${d.dayOfMonth} ${HISTORY_MONTHS_FR[d.monthNumber - 1]} ${d.year}"

/**
 * Écran « historique d'une catégorie » : ouvert au clic sur une tuile du Profil. Liste les questions
 * DISTINCTES déjà posées dans cette catégorie ; un clic déplie les dates de chaque passage avec un
 * indicateur ✓/✗. En-tête : « N questions posées dont X distinctes ».
 */
@Composable
fun CategoryHistoryScreen(
    modifier: Modifier = Modifier,
    history: CategoryHistory,
    onBack: () -> Unit
) {
    val cat = catColors(history.category)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
    ) {
        Header(cat = cat, title = history.category.displayName, icon = categoryIcon(history.category), onBack = onBack)

        Text(
            text = countsLabel(history.totalAsked, history.distinctCount),
            style = MaterialTheme.typography.bodyMedium,
            color = TriviaPalette.inkSoft,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 12.dp)
        )

        if (history.items.isEmpty()) {
            EmptyState()
        } else {
            val expanded = remember { mutableStateMapOf<String, Boolean>() }
            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 18.dp),
                verticalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                items(history.items, key = { it.question.id }) { item ->
                    QuestionRow(
                        item = item,
                        accent = cat,
                        expanded = expanded[item.question.id] == true,
                        onToggle = { expanded[item.question.id] = !(expanded[item.question.id] == true) }
                    )
                }
                item { Spacer(Modifier.height(10.dp)) }
            }
        }
    }
}

private fun countsLabel(total: Int, distinct: Int): String {
    val posees = "$total question${if (total > 1) "s" else ""} posée${if (total > 1) "s" else ""}"
    val distinctes = "$distinct distincte${if (distinct > 1) "s" else ""}"
    return "$posees dont $distinctes"
}

@Composable
private fun Header(cat: CatColors, title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().background(cat.main).padding(start = 12.dp, end = 14.dp, top = 8.dp, bottom = 16.dp)) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onBack)
                .padding(horizontal = 6.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(AppIcons.ChevronLeft, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
            Text(
                "Profil",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
        }
        Spacer(Modifier.height(6.dp))
        Row(
            modifier = Modifier.padding(start = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier.size(34.dp).clip(RoundedCornerShape(11.dp)).background(Color.White.copy(alpha = 0.18f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            }
            Text(title, style = MaterialTheme.typography.headlineSmall, color = Color.White)
        }
    }
}

@Composable
private fun QuestionRow(
    item: QuestionHistoryItem,
    accent: CatColors,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    val label = item.question.title.ifBlank { item.question.text }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(TriviaPalette.card)
            .clickable(onClick = onToggle)
            .padding(horizontal = 14.dp, vertical = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleSmall,
                color = TriviaPalette.ink,
                modifier = Modifier.weight(1f)
            )
            // Pastille du nombre de passages.
            Box(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(accent.tint).padding(horizontal = 8.dp, vertical = 3.dp)
            ) {
                Text("${item.attempts.size}×", style = MaterialTheme.typography.labelMedium, color = accent.deep)
            }
            Icon(
                if (expanded) AppIcons.ChevronLeft else AppIcons.ChevronRight,
                contentDescription = null,
                tint = TriviaPalette.inkFaint,
                modifier = Modifier.size(18.dp)
            )
        }

        if (expanded) {
            Spacer(Modifier.height(10.dp))
            Box(Modifier.fillMaxWidth().height(1.dp).background(TriviaPalette.line))
            Spacer(Modifier.height(8.dp))
            Text(
                text = item.question.text,
                style = MaterialTheme.typography.bodyMedium,
                color = TriviaPalette.inkSoft
            )
            Spacer(Modifier.height(8.dp))
            item.attempts.forEach { attempt ->
                Row(
                    modifier = Modifier.padding(vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val good = attempt.correct
                    Box(
                        modifier = Modifier.size(20.dp).clip(RoundedCornerShape(50))
                            .background(if (good) TriviaPalette.good else TriviaPalette.bad),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            if (good) AppIcons.Check else AppIcons.Close,
                            contentDescription = if (good) "Bonne réponse" else "Mauvaise réponse",
                            tint = Color.White,
                            modifier = Modifier.size(13.dp)
                        )
                    }
                    Text(formatHistoryDate(attempt.date), style = MaterialTheme.typography.bodyMedium, color = TriviaPalette.ink)
                }
            }
        }
    }
}

@Composable
private fun EmptyState() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Aucune question posée pour l'instant",
            style = MaterialTheme.typography.titleMedium,
            color = TriviaPalette.ink
        )
        Text(
            "Joue dans cette catégorie : les questions posées apparaîtront ici avec leurs dates.",
            style = MaterialTheme.typography.bodyMedium,
            color = TriviaPalette.inkSoft,
            fontSize = 13.sp
        )
    }
}
