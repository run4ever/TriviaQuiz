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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabien.trivia.data.displayName
import com.fabien.trivia.ui.game.CategoryHistory
import com.fabien.trivia.ui.game.RecentAttempt
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
 * Écran « historique d'une catégorie » : ouvert au clic sur une tuile du Profil. Liste plate des
 * derniers passages (au plus 100, du plus récent au plus ancien) : chaque ligne = ✓/✗ + question + date.
 * On n'affiche plus le nombre d'occurrences ni le détail daté par question (l'historique est plafonné).
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
            text = recentLabel(history.attempts.size),
            style = MaterialTheme.typography.bodyMedium,
            color = TriviaPalette.inkSoft,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 12.dp)
        )

        if (history.attempts.isEmpty()) {
            EmptyState()
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 18.dp),
                verticalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                items(history.attempts) { attempt ->
                    AttemptRow(attempt = attempt, accent = cat)
                }
                item { Spacer(Modifier.height(10.dp)) }
            }
        }
    }
}

private fun recentLabel(count: Int): String =
    if (count == 0) "Aucun passage récent"
    else "$count dernier${if (count > 1) "s" else ""} passage${if (count > 1) "s" else ""}"

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
private fun AttemptRow(attempt: RecentAttempt, accent: CatColors) {
    val good = attempt.correct
    val label = attempt.question.title.ifBlank { attempt.question.text }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(TriviaPalette.card)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(11.dp)
    ) {
        Box(
            modifier = Modifier.size(24.dp).clip(RoundedCornerShape(50))
                .background(if (good) TriviaPalette.good else TriviaPalette.bad),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                if (good) AppIcons.Check else AppIcons.Close,
                contentDescription = if (good) "Bonne réponse" else "Mauvaise réponse",
                tint = Color.White,
                modifier = Modifier.size(14.dp)
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleSmall,
                color = TriviaPalette.ink
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = formatHistoryDate(attempt.date),
                style = MaterialTheme.typography.bodyMedium,
                color = TriviaPalette.inkSoft,
                fontSize = 12.sp
            )
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
            "Joue dans cette catégorie : tes derniers passages apparaîtront ici.",
            style = MaterialTheme.typography.bodyMedium,
            color = TriviaPalette.inkSoft,
            fontSize = 13.sp
        )
    }
}
