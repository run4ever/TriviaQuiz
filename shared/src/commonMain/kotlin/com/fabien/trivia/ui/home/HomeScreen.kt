package com.fabien.trivia.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.components.LevelPill
import com.fabien.trivia.ui.components.ProgressRing
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.Rank
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon
import com.fabien.trivia.ui.theme.levelName
import com.fabien.trivia.ui.theme.progressToNextRank
import com.fabien.trivia.ui.theme.strengths
import com.fabien.trivia.ui.theme.weaknesses
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    playerRating: Int,
    categoryRatings: Map<Category, Int>,
    streak: Int,
    onStartAllCategories: () -> Unit,
    onChooseCategory: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp, vertical = 14.dp)
    ) {
        PlayerHeader(streak)
        Spacer(Modifier.height(18.dp))
        LevelHeroCard(playerRating)
        Spacer(Modifier.height(16.dp))
        PlayCta(onStartAllCategories)
        Spacer(Modifier.height(12.dp))
        CategoryCta(onChooseCategory)

        val strengths = categoryRatings.strengths()
        if (strengths.isNotEmpty()) {
            Spacer(Modifier.height(24.dp))
            CatStrip("Tes points forts", strengths)
        }
        val weaknesses = categoryRatings.weaknesses()
        if (weaknesses.isNotEmpty()) {
            Spacer(Modifier.height(20.dp))
            CatStrip("Tes axes d'amélioration", weaknesses)
        }
        Spacer(Modifier.height(8.dp))
    }
}

private fun greetingWord(): String {
    val hour = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).hour
    return if (hour < 17) "Bonjour" else "Bonsoir"
}

@Composable
private fun PlayerHeader(streak: Int) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Brush.linearGradient(listOf(TriviaPalette.brand, Color(0xFFEC4899)))),
            contentAlignment = Alignment.Center
        ) {
            Icon(AppIcons.Star, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
        }
        Spacer(Modifier.width(12.dp))
        Text(
            text = greetingWord(),
            style = MaterialTheme.typography.headlineSmall,
            color = TriviaPalette.ink,
            modifier = Modifier.weight(1f)
        )
        if (streak > 0) StreakPill(streak)
    }
}

@Composable
private fun StreakPill(streak: Int) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(TriviaPalette.card)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(AppIcons.Flame, contentDescription = null, tint = TriviaPalette.gold, modifier = Modifier.size(19.dp))
        Text("$streak", style = MaterialTheme.typography.titleMedium, color = TriviaPalette.ink)
    }
}

@Composable
private fun LevelHeroCard(playerRating: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(
                Brush.linearGradient(listOf(Color(0xFF231C46), Color(0xFF3A2A7A), Color(0xFF5B3FD6)))
            )
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProgressRing(fraction = progressToNextRank(playerRating), ringSize = 84.dp) {
                Icon(AppIcons.Crown, contentDescription = null, tint = TriviaPalette.gold, modifier = Modifier.size(34.dp))
            }
            Spacer(Modifier.width(18.dp))
            Column {
                Text(
                    text = "NIVEAU ACTUEL",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFFC9BEFF),
                    letterSpacing = 1.2.sp
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = playerRating.levelName(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
                Spacer(Modifier.height(2.dp))
                Row {
                    Text(
                        text = "$playerRating",
                        style = MaterialTheme.typography.titleLarge,
                        color = TriviaPalette.gold,
                        modifier = Modifier.alignByBaseline()
                    )
                    Spacer(Modifier.width(6.dp))
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
    }
}

@Composable
private fun PlayCta(onClick: () -> Unit) {
    ChunkyButton(
        onClick = onClick,
        color = TriviaPalette.brand,
        deep = TriviaPalette.brandDeep,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text("Jouer", style = MaterialTheme.typography.titleLarge, color = Color.White)
            Text(
                "Solo · toutes catégories",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.85f)
            )
        }
        PlayBadge()
    }
}

@Composable
private fun CategoryCta(onClick: () -> Unit) {
    ChunkyButton(
        onClick = onClick,
        color = TriviaPalette.night,
        deep = Color.Black,
        modifier = Modifier.fillMaxWidth()
    ) {
        CategoryChips()
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text("Jouer une catégorie", style = MaterialTheme.typography.titleMedium, color = Color.White)
            Text(
                "Au choix parmi 6",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.82f)
            )
        }
        PlayBadge()
    }
}

@Composable
private fun PlayBadge() {
    Box(
        modifier = Modifier
            .size(46.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.White.copy(alpha = 0.18f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(AppIcons.Play, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
    }
}

@Composable
private fun CategoryChips() {
    val chipW = 16.dp
    val step = 9.dp
    Box(modifier = Modifier.height(34.dp).width(chipW + step * 5)) {
        Category.entries.forEachIndexed { index, category ->
            Box(
                modifier = Modifier
                    .offset(x = step * index)
                    .size(width = chipW, height = 34.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(catColors(category).main)
                    .border(2.dp, Color.White.copy(alpha = 0.55f), RoundedCornerShape(5.dp))
            )
        }
    }
}

@Composable
private fun CatStrip(title: String, cats: List<Map.Entry<Category, Int>>) {
    Text(title, style = MaterialTheme.typography.titleMedium, color = TriviaPalette.ink, fontWeight = FontWeight.ExtraBold)
    Spacer(Modifier.height(12.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        cats.forEach { (category, rating) ->
            CatPick(category, rating, Modifier.weight(1f))
        }
    }
}

@Composable
private fun CatPick(category: Category, rating: Int, modifier: Modifier) {
    val colors = catColors(category)
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(colors.main),
            contentAlignment = Alignment.Center
        ) {
            Icon(categoryIcon(category), contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
        }
        Spacer(Modifier.height(6.dp))
        Text(
            category.displayName,
            style = MaterialTheme.typography.bodySmall,
            color = TriviaPalette.ink
        )
        Spacer(Modifier.height(4.dp))
        LevelPill(rating = rating, bg = colors.tint, fg = colors.deep)
    }
}
