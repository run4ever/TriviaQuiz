package com.fabien.trivia.ui.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette

/**
 * Écran de personnalisation de l'avatar : aperçu en direct + choix du **style** (8 vignettes) + grille des
 * **30 animaux** + Enregistrer. Crédit Kenney en bas (CC0). Réservé aux comptes email.
 */
@Composable
fun AvatarPickerScreen(
    modifier: Modifier = Modifier,
    currentAnimal: String?,
    currentStyle: String?,
    onSave: (animal: String, style: String) -> Unit,
    onBack: () -> Unit,
) {
    var animal by remember { mutableStateOf(currentAnimal ?: DEFAULT_AVATAR_ANIMAL) }
    var style by remember { mutableStateOf(currentStyle ?: DEFAULT_AVATAR_STYLE) }
    var hovered by remember { mutableStateOf<String?>(null) }

    Column(modifier = modifier.fillMaxSize().background(TriviaPalette.bg)) {
        // En-tête « ‹ retour » + titre
        Column(modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 14.dp, top = 6.dp)) {
            Row(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).clickable(onClick = onBack).padding(horizontal = 6.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(AppIcons.ChevronLeft, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(18.dp))
                Text("Retour", style = MaterialTheme.typography.titleSmall, color = TriviaPalette.brand)
            }
            Text(
                "Mon avatar",
                style = MaterialTheme.typography.headlineSmall,
                color = TriviaPalette.ink,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 6.dp, top = 2.dp, bottom = 6.dp),
            )
        }

        // Aperçu en direct + nom de l'animal (survolé sinon sélectionné)
        Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Avatar(animal = animal, style = style, pseudo = "", seed = animal, size = 104.dp)
            Spacer(Modifier.height(6.dp))
            Text(
                animalName(hovered ?: animal),
                style = MaterialTheme.typography.titleMedium,
                color = TriviaPalette.ink,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        SectionLabel("Style")
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(AVATAR_STYLES, key = { it.first }) { (styleId, label) ->
                StyleTile(animal = animal, styleId = styleId, label = label, selected = styleId == style) { style = styleId }
            }
        }

        SectionLabel("Animal")
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(AVATAR_ANIMALS, key = { it }) { a ->
                AnimalCell(
                    animalId = a,
                    style = style,
                    selected = a == animal,
                    onHover = { h -> if (h) hovered = a else if (hovered == a) hovered = null },
                    onClick = { animal = a },
                )
            }
        }

        ChunkyButton(
            onClick = { onSave(animal, style) },
            color = TriviaPalette.brand,
            deep = TriviaPalette.brandDeep,
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Text(
                "Enregistrer",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
        Text(
            "Avatars : Kenney.nl (CC0)",
            style = MaterialTheme.typography.bodySmall,
            color = TriviaPalette.inkFaint,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
        )
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text,
        style = MaterialTheme.typography.titleSmall,
        color = TriviaPalette.inkSoft,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(start = 18.dp, top = 12.dp, bottom = 8.dp),
    )
}

/** Cellule sélectionnable (cadre surligné si [selected]) contenant un [content] (avatar). */
@Composable
private fun PickCell(selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) TriviaPalette.brand.copy(alpha = 0.12f) else TriviaPalette.card)
            .border(2.dp, if (selected) TriviaPalette.brand else TriviaPalette.line, RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(8.dp),
        contentAlignment = Alignment.Center,
    ) { content() }
}

/** Vignette de style : l'animal courant rendu dans ce style + libellé sous la vignette. */
@Composable
private fun StyleTile(animal: String, styleId: String, label: String, selected: Boolean, onClick: () -> Unit) {
    Column(modifier = Modifier.width(82.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        PickCell(selected = selected, onClick = onClick) {
            Avatar(animal = animal, style = styleId, pseudo = "", seed = animal, size = 48.dp)
        }
        Spacer(Modifier.height(4.dp))
        Text(
            label,
            style = MaterialTheme.typography.labelSmall,
            color = if (selected) TriviaPalette.brand else TriviaPalette.inkSoft,
            fontSize = 10.sp,
            maxLines = 2,
            textAlign = TextAlign.Center,
        )
    }
}

/** Cellule animal de la grille : sélection + détection de survol (pour afficher le nom de l'animal). */
@Composable
private fun AnimalCell(animalId: String, style: String, selected: Boolean, onHover: (Boolean) -> Unit, onClick: () -> Unit) {
    val interaction = remember { MutableInteractionSource() }
    val isHovered by interaction.collectIsHoveredAsState()
    LaunchedEffect(isHovered) { onHover(isHovered) }
    PickCell(selected = selected, onClick = onClick, modifier = Modifier.hoverable(interaction)) {
        Avatar(animal = animalId, style = style, pseudo = "", seed = animalId, size = 56.dp)
    }
}
