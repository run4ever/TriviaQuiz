package com.fabien.trivia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue

private val AvatarGradients = listOf(
    listOf(Color(0xFF6366F1), Color(0xFFA855F7)),
    listOf(Color(0xFFEC4899), Color(0xFFF97316)),
    listOf(Color(0xFF06B6D4), Color(0xFF3B82F6)),
    listOf(Color(0xFF10B981), Color(0xFF84CC16)),
    listOf(Color(0xFFF59E0B), Color(0xFFEF4444)),
    listOf(Color(0xFF8B5CF6), Color(0xFFEC4899)),
)

/**
 * Avatar « placeholder » déterministe : dégradé choisi à partir de [seed] (ex. l'UID → stable par
 * personne, ne scintille pas) + initiale du [pseudo]. En attendant la vraie gestion d'avatars.
 */
@Composable
fun PseudoAvatar(
    pseudo: String,
    seed: String,
    size: Dp,
    modifier: Modifier = Modifier,
    corner: Dp = size * 0.30f,
) {
    val gradient = AvatarGradients[seed.hashCode().absoluteValue % AvatarGradients.size]
    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(corner))
            .background(Brush.linearGradient(gradient)),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = pseudo.trim().take(1).uppercase().ifBlank { "?" },
            style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = (size.value * 0.42f).sp, color = Color.White),
        )
    }
}
