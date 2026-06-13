package com.fabien.trivia.ui.theme

import androidx.compose.ui.graphics.Color
import com.fabien.trivia.data.Category

/**
 * Couleurs d'une catégorie (refonte « Vitamine »).
 * - [main] : teinte vive (fond de carte) · [deep] : ombre 3D + texte sur clair · [tint] : fond doux (pastille).
 */
data class CatColors(val main: Color, val deep: Color, val tint: Color)

val categoryColors: Map<Category, CatColors> = mapOf(
    Category.GEOGRAPHIE to CatColors(Color(0xFF0FA697), Color(0xFF0A6F63), Color(0xFFD6F4EF)),
    Category.HISTOIRE to CatColors(Color(0xFFE5890F), Color(0xFF9C5A05), Color(0xFFFBEBCF)),
    Category.SCIENCES_ET_NATURE to CatColors(Color(0xFF7A5AF8), Color(0xFF553BD0), Color(0xFFE7E1FF)),
    Category.ART_ET_CULTURE to CatColors(Color(0xFFEC4899), Color(0xFFC42B73), Color(0xFFFBDFEC)),
    Category.SPORTS to CatColors(Color(0xFF1FA84B), Color(0xFF157A36), Color(0xFFD5F2DD)),
    Category.DIVERTISSEMENT to CatColors(Color(0xFF3B82F6), Color(0xFF1D5FD8), Color(0xFFDCE9FF)),
)

fun catColors(category: Category): CatColors = categoryColors.getValue(category)

/**
 * Palette neutre + accents de la refonte. Tokens utilisés directement par les écrans Accueil
 * et Catégories (peinture locale, hors `MaterialTheme`, le temps de propager le style).
 */
object TriviaPalette {
    val bg = Color(0xFFFBF7F2)        // fond crème chaud
    val card = Color(0xFFFFFFFF)
    val ink = Color(0xFF1E1B2E)       // texte principal
    val inkSoft = Color(0xFF6B6680)   // texte secondaire
    val inkFaint = Color(0xFFA7A2B6)  // texte tertiaire
    val line = Color(0xFFECE6F0)

    val good = Color(0xFF1FA84B)
    val goodTint = Color(0xFFD5F2DD)
    val bad = Color(0xFFEF4444)
    val badTint = Color(0xFFFBE0E0)
    val gold = Color(0xFFF5B716)      // série, couronne, rating

    val brand = Color(0xFF7A5AF8)     // accent produit (violet)
    val brandDeep = Color(0xFF553BD0)

    val night = Color(0xFF161320)     // bouton « Jouer un thème » (noir)
}
