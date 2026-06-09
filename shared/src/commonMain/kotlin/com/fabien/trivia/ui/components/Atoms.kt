package com.fabien.trivia.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.withFrameNanos
import kotlin.random.Random
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.levelName

/**
 * Bouton « chunky » 3D : une tranche pleine [deep] sous la face [color], qui s'enfonce au
 * toucher (sans ripple). Signature de la refonte (cf. Notes Compose §3).
 */
@Composable
fun ChunkyButton(
    onClick: () -> Unit,
    color: Color,
    deep: Color,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(22.dp),
    depth: Dp = 7.dp,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
    content: @Composable RowScope.() -> Unit,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val sink by animateDpAsState(
        targetValue = if (pressed) depth else 0.dp,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label = "chunky-sink",
    )

    Box(modifier = modifier) {
        // Tranche 3D : remplit toute la surface, visible sur les 'depth' du bas.
        Box(
            Modifier
                .matchParentSize()
                .padding(top = depth)
                .background(deep, shape)
        )
        // Face avant : réserve 'depth' en bas et s'enfonce quand pressée.
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = depth)
                .offset(y = sink)
                .background(color, shape)
                .clip(shape)
                .clickable(interactionSource = interaction, indication = null, onClick = onClick)
                .padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            content = content,
        )
    }
}

/**
 * Anneau de progression (carte « Niveau actuel »). [fraction] 0f..1f, animé.
 * Le contenu central (icône couronne, etc.) est passé en [content].
 */
@Composable
fun ProgressRing(
    fraction: Float,
    modifier: Modifier = Modifier,
    ringSize: Dp = 84.dp,
    stroke: Dp = 8.dp,
    color: Color = TriviaPalette.gold,
    track: Color = Color.White.copy(alpha = 0.14f),
    content: @Composable BoxScope.() -> Unit = {},
) {
    val f by animateFloatAsState(fraction.coerceIn(0f, 1f), tween(800), label = "ring")
    Box(modifier = modifier.size(ringSize), contentAlignment = Alignment.Center) {
        Canvas(Modifier.fillMaxSize()) {
            val sw = stroke.toPx()
            val arc = Size(size.width - sw, size.height - sw)
            val topLeft = Offset(sw / 2f, sw / 2f)
            drawArc(track, 0f, 360f, false, topLeft = topLeft, size = arc, style = Stroke(sw))
            drawArc(color, -90f, 360f * f, false, topLeft = topLeft, size = arc, style = Stroke(sw, cap = StrokeCap.Round))
        }
        content()
    }
}

private class Confetto(
    var x: Float,
    var y: Float,
    val vx: Float,
    var vy: Float,
    val color: Color,
    val radius: Float,
)

/**
 * Confettis de victoire — particules simulées dans un Canvas (100 % commonMain, marche sur iOS).
 * Émises depuis le bas, projetées vers le haut puis retombent (gravité). Burst unique.
 */
@Composable
fun Confetti(
    palette: List<Color>,
    modifier: Modifier = Modifier,
    count: Int = 30,
) {
    val parts = remember {
        List(count) {
            Confetto(
                x = 0.5f + (Random.nextFloat() - 0.5f) * 0.5f,
                y = 1f,
                vx = (Random.nextFloat() - 0.5f) * 0.9f,
                vy = -(Random.nextFloat() * 0.7f + 0.7f),
                color = palette.random(),
                radius = Random.nextFloat() * 6f + 4f,
            )
        }
    }
    var tick by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) {
            withFrameNanos {
                parts.forEach { p ->
                    p.x += p.vx * 0.016f
                    p.vy += 1.4f * 0.016f // gravité
                    p.y += p.vy * 0.016f
                }
                tick++
            }
        }
    }
    Canvas(modifier = modifier.fillMaxSize()) {
        tick // lecture pour redessiner à chaque frame
        parts.forEach { p ->
            drawCircle(p.color, p.radius, Offset(p.x * size.width, p.y * size.height))
        }
    }
}

/** Pastille de niveau : couronne + points + libellé du niveau, sur fond [bg], texte/icône [fg]. */
@Composable
fun LevelPill(
    rating: Int,
    bg: Color,
    fg: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(bg, RoundedCornerShape(20.dp))
            .padding(horizontal = 9.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(AppIcons.Crown, contentDescription = null, tint = fg, modifier = Modifier.size(12.dp))
        Text("$rating", style = MaterialTheme.typography.labelSmall, color = fg)
        Text(rating.levelName(), style = MaterialTheme.typography.labelSmall, color = fg)
    }
}
