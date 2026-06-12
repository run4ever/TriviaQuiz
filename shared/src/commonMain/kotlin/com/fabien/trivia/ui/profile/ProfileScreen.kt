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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.displayName
import com.fabien.trivia.ui.avatar.Avatar
import com.fabien.trivia.ui.components.ProgressRing
import com.fabien.trivia.ui.game.ProfileStats
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.Rank
import com.fabien.trivia.ui.theme.SIGNUP_RATING
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon
import com.fabien.trivia.ui.theme.levelName
import com.fabien.trivia.ui.theme.progressToNextRank
import kotlinx.datetime.LocalDate

private val MONTHS_FR = listOf(
    "janv.", "févr.", "mars", "avril", "mai", "juin",
    "juil.", "août", "sept.", "oct.", "nov.", "déc."
)

private fun formatStreakDate(d: LocalDate): String =
    "${d.dayOfMonth} ${MONTHS_FR[d.monthNumber - 1]} ${d.year}"

/** Taux de réussite en % entier (bonnes réponses / questions posées). 0 si aucune question posée. */
private fun successRate(asked: Int, correct: Int): Int =
    if (asked > 0) (correct * 100) / asked else 0

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    playerRating: Int,
    categoryRatings: Map<Category, Int>,
    accountStatus: String,
    pseudo: String,
    avatarAnimal: String?,
    avatarStyle: String?,
    isSignedIn: Boolean,
    stats: ProfileStats,
    onOpenAccount: () -> Unit,
    onSelectCategory: (Category) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Mon profil",
            style = MaterialTheme.typography.headlineSmall,
            color = TriviaPalette.ink,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        AccountCard(isSignedIn, pseudo, avatarAnimal, avatarStyle, accountStatus, onOpenAccount)
        GlobalLevelCard(
            playerRating = playerRating,
            globalBest = stats.globalBest,
            globalBestDate = stats.globalBestDate,
            asked = stats.globalAsked,
            correct = stats.globalCorrect
        )

        Text(
            text = "Par catégorie",
            style = MaterialTheme.typography.titleMedium,
            color = TriviaPalette.ink,
            fontWeight = FontWeight.ExtraBold
        )

        Category.entries.chunked(2).forEach { rowCats ->
            Row(horizontalArrangement = Arrangement.spacedBy(11.dp)) {
                rowCats.forEach { category ->
                    val rating = categoryRatings[category] ?: SIGNUP_RATING
                    CategoryStatTile(
                        category = category,
                        rating = rating,
                        best = stats.categoryBest[category] ?: 0,
                        bestDate = stats.categoryBestDate[category],
                        asked = stats.categoryAsked[category] ?: 0,
                        correct = stats.categoryCorrect[category] ?: 0,
                        onClick = { onSelectCategory(category) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
        Spacer(Modifier.height(4.dp))
    }
}

@Composable
private fun AccountCard(isSignedIn: Boolean, pseudo: String, avatarAnimal: String?, avatarStyle: String?, accountStatus: String, onOpenAccount: () -> Unit) {
    val hasPseudo = pseudo.isNotBlank()
    val title = if (hasPseudo) "PSEUDO" else "COMPTE"
    val value = if (hasPseudo) pseudo else accountStatus
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(TriviaPalette.card)
            .clickable(onClick = onOpenAccount)
            .padding(horizontal = 14.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Avatar(animal = avatarAnimal, style = avatarStyle, pseudo = pseudo, seed = value, size = 44.dp, modifier = Modifier.clip(RoundedCornerShape(14.dp)))
        Column(modifier = Modifier.weight(1f)) {
            if (isSignedIn) {
                ConnectedBadge()
                Spacer(Modifier.height(3.dp))
            } else {
                Text(text = title, style = MaterialTheme.typography.labelSmall, color = TriviaPalette.inkFaint)
            }
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                color = TriviaPalette.ink,
                maxLines = 1
            )
        }
        Icon(AppIcons.ChevronRight, contentDescription = null, tint = TriviaPalette.inkFaint, modifier = Modifier.size(20.dp))
    }
}

/** Badge « ✓ Connecté » (même style que la carte de l'écran « Mon compte »). */
@Composable
private fun ConnectedBadge() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(TriviaPalette.goodTint)
            .padding(horizontal = 9.dp, vertical = 3.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(AppIcons.Check, contentDescription = null, tint = TriviaPalette.good, modifier = Modifier.size(12.dp))
        Text(
            text = "Connecté",
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 10.5.sp,
            letterSpacing = 0.3.sp,
            color = TriviaPalette.good
        )
    }
}

@Composable
private fun GlobalLevelCard(playerRating: Int, globalBest: Int, globalBestDate: LocalDate?, asked: Int, correct: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(Brush.linearGradient(listOf(Color(0xFF231C46), Color(0xFF3A2A7A), Color(0xFF5B3FD6))))
            .padding(horizontal = 18.dp, vertical = 13.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProgressRing(fraction = progressToNextRank(playerRating), ringSize = 66.dp, stroke = 8.dp) {
                Icon(AppIcons.Crown, contentDescription = null, tint = TriviaPalette.gold, modifier = Modifier.size(22.dp))
            }
            Spacer(Modifier.width(15.dp))
            Column {
                Text(
                    text = "NIVEAU GLOBAL",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFFC9BEFF),
                    letterSpacing = 1.1.sp
                )
                Text(
                    text = playerRating.levelName(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
                Row {
                    Text(
                        text = "$playerRating",
                        style = MaterialTheme.typography.titleLarge,
                        color = TriviaPalette.gold,
                        modifier = Modifier.alignByBaseline()
                    )
                    Spacer(Modifier.width(7.dp))
                    val next = Rank.next(playerRating)
                    Text(
                        text = if (next != null) "pts · ${next.min - playerRating} pour ${next.label}" else "pts · rang max",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFC9BEFF),
                        modifier = Modifier.alignByBaseline()
                    )
                }
            }
        }

        val hasActivity = asked > 0
        val hasBest = globalBest > 0
        if (hasActivity || hasBest) {
            Spacer(Modifier.height(11.dp))
            Box(Modifier.fillMaxWidth().height(1.dp).background(Color.White.copy(alpha = 0.13f)))
            Spacer(Modifier.height(10.dp))
            if (hasActivity) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "$asked question${if (asked > 1) "s" else ""} posées${if (asked > 1) "s" else ""}",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )
                    Text(
                        text = "· ${successRate(asked, correct)} % de réussite",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFC9BEFF)
                    )
                    Icon(AppIcons.Sparkle, contentDescription = null, tint = TriviaPalette.gold, modifier = Modifier.size(16.dp))
                }
                if (hasBest) Spacer(Modifier.height(9.dp))
            }
            if (hasBest) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(AppIcons.Flame, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
                    Text("$globalBest", style = MaterialTheme.typography.titleSmall, color = Color.White)
                    Text(
                        text = if (globalBestDate != null) "Meilleure série le ${formatStreakDate(globalBestDate)}" else "Meilleure série",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFC9BEFF)
                    )
                }
            }
        }
    }
}

@Composable
private fun CategoryStatTile(
    category: Category,
    rating: Int,
    best: Int,
    bestDate: LocalDate?,
    asked: Int,
    correct: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = catColors(category)
    val shape = RoundedCornerShape(18.dp)
    val depth = 5.dp
    val overlay = Color.White.copy(alpha = 0.18f)

    Box(modifier = modifier) {
        Box(Modifier.matchParentSize().padding(top = depth).background(colors.deep, shape))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = depth)
                .clip(shape)
                .background(colors.main)
                .clickable(onClick = onClick)
                .heightIn(min = 140.dp)
                .padding(horizontal = 13.dp, vertical = 11.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.size(30.dp).clip(RoundedCornerShape(10.dp)).background(overlay),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(categoryIcon(category), contentDescription = null, tint = Color.White, modifier = Modifier.size(17.dp))
                }
                Row(
                    modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(overlay).padding(horizontal = 8.dp, vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(AppIcons.Crown, contentDescription = null, tint = Color.White, modifier = Modifier.size(10.dp))
                    Text(rating.levelName(), style = MaterialTheme.typography.labelSmall, color = Color.White)
                }
            }

            Spacer(Modifier.height(5.dp))
            Text(category.displayName, style = MaterialTheme.typography.titleMedium, color = Color.White)
            Row {
                Text("$rating", style = MaterialTheme.typography.titleLarge, color = Color.White, modifier = Modifier.alignByBaseline())
                Spacer(Modifier.width(4.dp))
                Text("pts", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.8f), modifier = Modifier.alignByBaseline())
            }

            Spacer(Modifier.weight(1f))

            val hasActivity = asked > 0
            val hasBest = best > 0
            if (hasActivity || hasBest) {
                Box(Modifier.fillMaxWidth().height(1.dp).background(overlay))
                Spacer(Modifier.height(7.dp))
            }
            if (hasActivity) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "$asked posée${if (asked > 1) "s" else ""} · ${successRate(asked, correct)} %",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                    Icon(AppIcons.Sparkle, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                }
                if (hasBest) Spacer(Modifier.height(7.dp))
            }
            if (hasBest) {
                Text("Meilleure série :", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.8f))
                Spacer(Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Icon(AppIcons.Flame, contentDescription = null, tint = Color.White, modifier = Modifier.size(19.dp))
                    Text(
                        text = if (bestDate != null) "$best, le ${formatStreakDate(bestDate)}" else "$best",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
            }
        }
    }
}
