package com.fabien.trivia.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.DirectoryEntry
import com.fabien.trivia.data.displayName
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.components.PseudoAvatar
import com.fabien.trivia.ui.components.LevelPill
import com.fabien.trivia.ui.components.ProgressRing
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.Rank
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon
import com.fabien.trivia.ui.theme.levelName
import com.fabien.trivia.ui.theme.progressToNextRank
import com.fabien.trivia.ui.theme.homeHighlights
import kotlin.time.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    playerRating: Int,
    categoryRatings: Map<Category, Int>,
    categoryAsked: Map<Category, Int>,
    streak: Int,
    pseudo: String,
    reviewCount: Int,
    isEmailUser: Boolean,
    friends: List<DirectoryEntry>,
    onStartAllCategories: () -> Unit,
    onChooseCategory: () -> Unit,
    onReview: () -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAccount: () -> Unit,
    onOpenFriends: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp, vertical = 14.dp)
    ) {
        PlayerHeader(streak, pseudo, onOpenAccount)
        Spacer(Modifier.height(18.dp))
        LevelHeroCard(playerRating, onOpenProfile)
        Spacer(Modifier.height(16.dp))
        PlayCta(onStartAllCategories)
        Spacer(Modifier.height(12.dp))
        CategoryCta(onChooseCategory)
        Spacer(Modifier.height(12.dp))
        ReviewCta(count = reviewCount, onClick = onReview)

        Spacer(Modifier.height(22.dp))
        FriendsSection(
            isEmailUser = isEmailUser,
            friends = friends,
            onOpenFriends = onOpenFriends,
            onOpenAccount = onOpenAccount,
        )

        // Points forts / axes d'amélioration : ≥2 questions posées requises, 2 mini par bloc, blocs disjoints.
        val highlights = homeHighlights(categoryRatings, categoryAsked)
        if (highlights.strengths.isNotEmpty()) {
            Spacer(Modifier.height(24.dp))
            CatStrip("Tes points forts", highlights.strengths)
        }
        if (highlights.weaknesses.isNotEmpty()) {
            Spacer(Modifier.height(20.dp))
            CatStrip("Tes axes d'amélioration", highlights.weaknesses)
        }
        Spacer(Modifier.height(8.dp))
    }
}

private fun greetingWord(): String {
    val hour = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).hour
    return if (hour < 17) "Bonjour" else "Bonsoir"
}

@Composable
private fun PlayerHeader(streak: Int, pseudo: String, onOpenAccount: () -> Unit) {
    val hasPseudo = pseudo.isNotBlank()
    // Valeur initiale recalculée à chaque (ré)entrée en composition (couvre les changements d'onglet),
    // puis rafraîchie sur ON_RESUME → au retour de l'arrière-plan (ex. ouverture le matin) le mot est
    // à jour sans recomposition forcée ni polling.
    var greeting by remember { mutableStateOf(greetingWord()) }
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        greeting = greetingWord()
    }
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        // H2 — la zone « avatar + Bonjour … » ouvre l'écran Compte (la pastille de série reste à part).
        Row(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(16.dp))
                .clickable(onClick = onOpenAccount),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Brush.linearGradient(listOf(TriviaPalette.brand, Color(0xFFEC4899)))),
                contentAlignment = Alignment.Center
            ) {
                if (hasPseudo) {
                    Text(
                        text = pseudo.take(1).uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                } else {
                    Icon(AppIcons.Star, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
                }
            }
            Spacer(Modifier.width(12.dp))
            Text(
                text = if (hasPseudo) "$greeting $pseudo" else greeting,
                style = MaterialTheme.typography.headlineSmall,
                color = TriviaPalette.ink,
                modifier = Modifier.weight(1f)
            )
        }
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
private fun LevelHeroCard(playerRating: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(
                Brush.linearGradient(listOf(Color(0xFF231C46), Color(0xFF3A2A7A), Color(0xFF5B3FD6)))
            )
            // H2 — la carte « Niveau global » ouvre l'onglet Profil.
            .clickable(onClick = onClick)
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
private fun ReviewCta(count: Int, onClick: () -> Unit) {
    val enabled = count > 0
    ChunkyButton(
        onClick = { if (enabled) onClick() },
        color = if (enabled) Color(0xFFF0A03E) else TriviaPalette.inkFaint,
        deep = if (enabled) Color(0xFFC8771C) else TriviaPalette.inkSoft,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White.copy(alpha = 0.18f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(AppIcons.Book, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text("Réviser mes erreurs", style = MaterialTheme.typography.titleMedium, color = Color.White)
            Text(
                if (enabled) "$count question${if (count > 1) "s" else ""} à revoir" else "Aucune erreur à revoir",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}

// ── Section « Amis » (accueil) : 3 états selon connexion / présence d'amis ──
@Composable
private fun FriendsSection(
    isEmailUser: Boolean,
    friends: List<DirectoryEntry>,
    onOpenFriends: () -> Unit,
    onOpenAccount: () -> Unit,
) {
    when {
        !isEmailUser -> FriendsPrompt("Connectez-vous pour rechercher vos amis", onOpenAccount)
        friends.isEmpty() -> FriendsPrompt("Recherchez vos amis", onOpenFriends)
        else -> {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("Amis", style = MaterialTheme.typography.titleMedium, color = TriviaPalette.ink, fontWeight = FontWeight.ExtraBold)
                Text(
                    "Afficher tout",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TriviaPalette.brand,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clip(RoundedCornerShape(8.dp)).clickable(onClick = onOpenFriends).padding(horizontal = 4.dp, vertical = 2.dp),
                )
            }
            Spacer(Modifier.height(12.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(friends, key = { it.uid }) { entry -> FriendMiniCard(entry, onOpenFriends) }
            }
        }
    }
}

@Composable
private fun FriendsPrompt(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(TriviaPalette.card)
            .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Box(
            modifier = Modifier.size(42.dp).clip(RoundedCornerShape(13.dp)).background(TriviaPalette.brand),
            contentAlignment = Alignment.Center,
        ) {
            Icon(AppIcons.Users, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
        }
        Text(text, style = MaterialTheme.typography.titleSmall, color = TriviaPalette.ink, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Icon(AppIcons.ChevronRight, contentDescription = null, tint = TriviaPalette.inkFaint, modifier = Modifier.size(20.dp))
    }
}

@Composable
private fun FriendMiniCard(entry: DirectoryEntry, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(TriviaPalette.card)
            .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 14.dp, horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PseudoAvatar(pseudo = entry.pseudo, seed = entry.uid, size = 52.dp)
        Spacer(Modifier.height(8.dp))
        Text(
            entry.pseudo.ifBlank { "Joueur" },
            style = MaterialTheme.typography.titleSmall,
            color = TriviaPalette.ink,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(Modifier.height(2.dp))
        Text(
            entry.rating.levelName(),
            style = MaterialTheme.typography.bodySmall,
            color = TriviaPalette.inkSoft,
            fontSize = 11.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
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
