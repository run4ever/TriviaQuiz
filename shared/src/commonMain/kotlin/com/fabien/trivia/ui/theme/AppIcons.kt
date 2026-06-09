package com.fabien.trivia.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp
import com.fabien.trivia.data.Category

/**
 * Icônes maison de la refonte « Vitamine », converties depuis les paths SVG de
 * `docs/design/accueil_categories/reference/tokens.js` (viewBox 24, stroke 2.2).
 *
 * Construites en noir : la couleur réelle vient du `tint` de `Icon(...)` au point d'usage.
 * Deux styles : trait (`line`) pour les contours, plein (`fill`) pour les formes pleines.
 */
private fun line(name: String, path: String): ImageVector =
    ImageVector.Builder(name, 24.dp, 24.dp, 24f, 24f).apply {
        addPath(
            pathData = PathParser().parsePathString(path).toNodes(),
            stroke = SolidColor(Color.Black),
            strokeLineWidth = 2.2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        )
    }.build()

private fun fill(name: String, path: String): ImageVector =
    ImageVector.Builder(name, 24.dp, 24.dp, 24f, 24f).apply {
        addPath(
            pathData = PathParser().parsePathString(path).toNodes(),
            fill = SolidColor(Color.Black),
        )
    }.build()

object AppIcons {
    // Catégories (contour)
    val Globe = line("globe", "M12 3a9 9 0 100 18 9 9 0 000-18zM3 12h18M12 3c2.5 2.4 2.5 15.6 0 18M12 3c-2.5 2.4-2.5 15.6 0 18")
    val Column = line("column", "M5 21h14M6 21V9M18 21V9M4 9h16l-8-5-8 5zM9 21V12M15 21V12")
    val Flask = line("flask", "M9 3h6M10 3v6l-5 9a2 2 0 002 3h10a2 2 0 002-3l-5-9V3M7.5 15h9")
    val Palette = line("palette", "M12 3a9 9 0 00-1 17.9c1 .1 1.6-.8 1.2-1.7-.5-1.2.4-2.2 1.6-2.2H17a4 4 0 004-4 9 9 0 00-9-10zM7.5 13a1 1 0 100-2 1 1 0 000 2zM9.5 8.5a1 1 0 100-2 1 1 0 000 2zM14.5 8a1 1 0 100-2 1 1 0 000 2z")
    val Trophy = line("trophy", "M7 4h10v4a5 5 0 01-10 0V4zM7 6H4v1a3 3 0 003 3M17 6h3v1a3 3 0 01-3 3M9 20h6M12 14v6M9 20l.5-2h5l.5 2")
    val Film = line("film", "M4 4h16v16H4zM4 9h16M4 15h16M9 4v16M15 4v16")

    // Navigation / UI (contour)
    val ChevronLeft = line("chevL", "M15 6l-6 6 6 6")
    val ChevronRight = line("chevR", "M9 6l6 6-6 6")
    val Home = line("home", "M4 11l8-7 8 7M6 10v9h12v-9")
    val Users = line("users", "M16 19v-1a4 4 0 00-4-4H6a4 4 0 00-4 4v1M9 11a3.5 3.5 0 100-7 3.5 3.5 0 000 7zM22 19v-1a4 4 0 00-3-3.8M16 4.2a4 4 0 010 7.6")
    val Close = line("x", "M6 6l12 12M18 6L6 18")
    val Check = line("check", "M5 12.5l4.5 4.5L19 6")

    // Pleins
    val Star = fill("star", "M12 3l2.6 5.3 5.9.9-4.3 4.1 1 5.8L12 16.9 6.8 19.2l1-5.8L3.5 9.2l5.9-.9z")
    val Crown = fill("crown", "M4 8l3.5 3L12 5l4.5 6L20 8l-1.5 10h-13L4 8z")
    val Flame = fill("flame", "M12 3c1 3 4 4.5 4 8a4 4 0 01-8 0c0-1.2.5-2 1-2.7C9.2 9.8 10 8 12 3z")
    val Play = fill("play", "M7 4l13 8-13 8V4z")
    val Bolt = fill("bolt", "M13 2L4.5 13.5H11l-1 8.5L18.5 10H12z")
}

/** Icône de la catégorie (carte Catégories, pastilles de l'Accueil). */
fun categoryIcon(category: Category): ImageVector = when (category) {
    Category.GEOGRAPHIE -> AppIcons.Globe
    Category.HISTOIRE -> AppIcons.Column
    Category.SCIENCES_ET_NATURE -> AppIcons.Flask
    Category.ART_ET_CULTURE -> AppIcons.Palette
    Category.SPORTS -> AppIcons.Trophy
    Category.DIVERTISSEMENT -> AppIcons.Film
}
