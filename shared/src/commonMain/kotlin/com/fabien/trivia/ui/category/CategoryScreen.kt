package com.fabien.trivia.ui.category

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.displayName
import com.fabien.trivia.ui.components.LevelPill
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.SIGNUP_RATING
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.catColors
import com.fabien.trivia.ui.theme.categoryIcon
import com.fabien.trivia.ui.theme.levelName

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    categoryRatings: Map<Category, Int>,
    onSelectCategory: (Category) -> Unit,
    onGoBack: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
            .padding(horizontal = 18.dp, vertical = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(TriviaPalette.card)
                    .clickable(onClick = onGoBack),
                contentAlignment = Alignment.Center
            ) {
                Icon(AppIcons.ChevronLeft, contentDescription = "Retour", tint = TriviaPalette.ink, modifier = Modifier.size(22.dp))
            }
            Spacer(Modifier.width(12.dp))
            Column {
                Text("Choisis un thème", style = MaterialTheme.typography.headlineSmall, color = TriviaPalette.ink)
                Text(
                    "Sur quoi veux-tu briller ?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TriviaPalette.inkFaint
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(13.dp),
            verticalArrangement = Arrangement.spacedBy(13.dp),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            items(Category.entries) { category ->
                CategoryCard(
                    category = category,
                    rating = categoryRatings[category] ?: SIGNUP_RATING,
                    onClick = { onSelectCategory(category) }
                )
            }
        }
    }
}

@Composable
private fun CategoryCard(category: Category, rating: Int, onClick: () -> Unit) {
    val colors = catColors(category)
    val shape = RoundedCornerShape(22.dp)
    val depth = 7.dp
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val sink by animateDpAsState(
        targetValue = if (pressed) depth else 0.dp,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label = "card-sink"
    )

    Box(modifier = Modifier.fillMaxWidth()) {
        // Tranche 3D (deep) sous la carte.
        Box(
            Modifier
                .matchParentSize()
                .padding(top = depth)
                .background(colors.deep, shape)
        )
        // Face avant colorée.
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = depth)
                .offset(y = sink)
                .background(colors.main, shape)
                .clip(shape)
                .clickable(interactionSource = interaction, indication = null, onClick = onClick)
                .heightIn(min = 128.dp)
                .padding(horizontal = 16.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White.copy(alpha = 0.18f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(categoryIcon(category), contentDescription = null, tint = Color.White, modifier = Modifier.size(26.dp))
            }
            Column {
                Text(category.displayName, style = MaterialTheme.typography.titleMedium, color = Color.White)
                Spacer(Modifier.height(6.dp))
                LevelPill(label = rating.levelName(), bg = Color.White.copy(alpha = 0.18f), fg = Color.White)
            }
        }
    }
}
