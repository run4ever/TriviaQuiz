package com.fabien.trivia.ui.multiplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette

/**
 * Composants partagés de la refonte « Vitamine » du multijoueur (handoff `docs/design/multijoueur`).
 * En-tête, champ de saisie, bouton chunky et bouton contour, réutilisés par les 7 écrans.
 */

/** En-tête commun écrans 1/2/3 : lien retour `‹ <label>` (brand) + titre centré. */
@Composable
fun MHeader(title: String, backLabel: String, onBack: () -> Unit) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    Column(modifier = Modifier.fillMaxWidth().padding(start = 18.dp, end = 18.dp, top = 6.dp)) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onBack)
                .padding(horizontal = 4.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(AppIcons.ChevronLeft, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(18.dp))
            Spacer(Modifier.size(3.dp))
            Text(
                backLabel,
                style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TriviaPalette.brand),
            )
        }
        Text(
            title,
            style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 23.sp, color = TriviaPalette.ink),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}

/** Champ de saisie « Vitamine » (label uppercase + boîte blanche, halo violet en focus). */
@Composable
fun MField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector = AppIcons.User,
    keyboardType: KeyboardType = KeyboardType.Text,
    accent: Color = TriviaPalette.brand,
) {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val interaction = remember { MutableInteractionSource() }
    val focused by interaction.collectIsFocusedAsState()
    val shape = RoundedCornerShape(15.dp)

    Column(modifier) {
        Text(
            label.uppercase(),
            style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 10.5.sp, letterSpacing = 0.6.sp, color = TriviaPalette.inkFaint),
            modifier = Modifier.padding(start = 2.dp, bottom = 6.dp),
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            interactionSource = interaction,
            textStyle = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp, color = TriviaPalette.ink),
            cursorBrush = SolidColor(accent),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            decorationBox = { inner ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                        .background(Color.White, shape)
                        .then(if (focused) Modifier.border(4.dp, accent.copy(alpha = 0.13f), shape) else Modifier)
                        .border(1.5.dp, if (focused) accent else TriviaPalette.line, shape)
                        .padding(horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Icon(icon, contentDescription = null, tint = if (focused) accent else TriviaPalette.inkFaint, modifier = Modifier.size(19.dp))
                    Box(modifier = Modifier.weight(1f)) { inner() }
                }
            },
        )
    }
}

/** Bouton chunky plein largeur avec icône + libellé centrés (CTA primaire). */
@Composable
fun MChunkyButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = TriviaPalette.brand,
    deep: Color = TriviaPalette.brandDeep,
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    ChunkyButton(
        onClick = { if (enabled) onClick() },
        color = if (enabled) color else TriviaPalette.inkFaint,
        deep = if (enabled) deep else TriviaPalette.inkSoft,
        shape = RoundedCornerShape(18.dp),
        modifier = modifier,
    ) {
        CenteredLabel(icon = icon, text = text, baloo = baloo, color = Color.White, fontSize = 18.sp)
    }
}

/** Bouton « contour » (blanc, bordure 2dp, sans ombre portée) : actions secondaires. */
@Composable
fun MContourButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    textColor: Color = TriviaPalette.ink,
    iconTint: Color = TriviaPalette.brand,
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    Row(
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(TriviaPalette.card)
            .border(2.dp, TriviaPalette.line, RoundedCornerShape(18.dp))
            .clickable(enabled = enabled, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        if (icon != null) {
            Icon(icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(19.dp))
            Spacer(Modifier.size(9.dp))
        }
        Text(
            text,
            style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 17.sp, color = textColor),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

/** Libellé de section (Baloo 2 ExtraBold). */
@Composable
fun MLabel(text: String) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    Text(
        text,
        style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp, color = TriviaPalette.ink),
        modifier = Modifier.padding(start = 2.dp),
    )
}

/** Contrôle segmenté : segment actif = pastille violette, inactif = transparent. */
@Composable
fun MSeg(
    options: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(TriviaPalette.card)
            .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(16.dp))
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        options.forEachIndexed { i, label ->
            val on = i == selectedIndex
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (on) TriviaPalette.brand else Color.Transparent)
                    .clickable { onSelect(i) }
                    .padding(vertical = 11.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    label,
                    style = TextStyle(
                        fontFamily = baloo,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp,
                        color = if (on) Color.White else TriviaPalette.inkSoft,
                    ),
                    maxLines = 1,
                )
            }
        }
    }
}

/** Rangée catégorie sélectionnable (pastille icône + nom + coche si active). */
@Composable
fun MCatRow(
    name: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tileColor: Color = TriviaPalette.brand,
    isAll: Boolean = false,
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val shape = RoundedCornerShape(16.dp)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(if (selected) TriviaPalette.brand.copy(alpha = 0.10f) else TriviaPalette.card)
            .border(1.5.dp, if (selected) TriviaPalette.brand else TriviaPalette.line, shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(11.dp))
                .then(
                    if (isAll) Modifier.background(Brush.linearGradient(listOf(TriviaPalette.brand, Color(0xFF9B7DFF))))
                    else Modifier.background(tileColor)
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
        }
        Text(
            name,
            style = TextStyle(
                fontFamily = baloo,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = if (selected) TriviaPalette.brandDeep else TriviaPalette.ink,
            ),
            modifier = Modifier.weight(1f),
        )
        if (selected) {
            Icon(AppIcons.Check, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(19.dp))
        }
    }
}

/** Icône + libellé centrés sur la largeur disponible (contenu de bouton). */
@Composable
internal fun RowScope.CenteredLabel(
    icon: ImageVector,
    text: String,
    baloo: androidx.compose.ui.text.font.FontFamily?,
    color: Color,
    fontSize: androidx.compose.ui.unit.TextUnit,
) {
    Row(
        modifier = Modifier.weight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(21.dp))
        Spacer(Modifier.size(10.dp))
        Text(text, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = fontSize, color = color))
    }
}
