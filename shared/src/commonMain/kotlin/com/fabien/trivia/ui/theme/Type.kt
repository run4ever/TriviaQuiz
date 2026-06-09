package com.fabien.trivia.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.fabien.trivia.resources.Res
import com.fabien.trivia.resources.baloo2_bold
import com.fabien.trivia.resources.baloo2_extrabold
import com.fabien.trivia.resources.baloo2_semibold
import com.fabien.trivia.resources.nunito_bold
import com.fabien.trivia.resources.nunito_extrabold
import com.fabien.trivia.resources.nunito_regular
import com.fabien.trivia.resources.nunito_semibold
import org.jetbrains.compose.resources.Font

/**
 * Typo « jeu » de la refonte : Baloo 2 (titres, scores, libellés de bouton, niveaux),
 * Nunito (corps de texte). Appliquée à toute l'app (les écrans non encore restylés en
 * profitent aussi — la typo est moins clivante que les couleurs).
 *
 * `Font(...)` de Compose Resources est `@Composable`, d'où la construction dans une fonction
 * `@Composable` plutôt qu'un `val` de premier niveau.
 */
@Composable
fun appTypography(): Typography {
    val baloo = FontFamily(
        Font(Res.font.baloo2_semibold, FontWeight.SemiBold),
        Font(Res.font.baloo2_bold, FontWeight.Bold),
        Font(Res.font.baloo2_extrabold, FontWeight.ExtraBold),
    )
    val nunito = FontFamily(
        Font(Res.font.nunito_regular, FontWeight.Normal),
        Font(Res.font.nunito_semibold, FontWeight.SemiBold),
        Font(Res.font.nunito_bold, FontWeight.Bold),
        Font(Res.font.nunito_extrabold, FontWeight.ExtraBold),
    )
    val base = Typography()
    return base.copy(
        displayLarge = base.displayLarge.copy(fontFamily = baloo, fontWeight = FontWeight.ExtraBold),
        displayMedium = base.displayMedium.copy(fontFamily = baloo, fontWeight = FontWeight.ExtraBold),
        displaySmall = base.displaySmall.copy(fontFamily = baloo, fontWeight = FontWeight.ExtraBold),
        headlineLarge = base.headlineLarge.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        headlineMedium = base.headlineMedium.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        headlineSmall = base.headlineSmall.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        titleLarge = base.titleLarge.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        titleMedium = base.titleMedium.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        titleSmall = base.titleSmall.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        bodyLarge = base.bodyLarge.copy(fontFamily = nunito, fontWeight = FontWeight.SemiBold),
        bodyMedium = base.bodyMedium.copy(fontFamily = nunito, fontWeight = FontWeight.SemiBold),
        bodySmall = base.bodySmall.copy(fontFamily = nunito, fontWeight = FontWeight.SemiBold),
        labelLarge = base.labelLarge.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        labelMedium = base.labelMedium.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
        labelSmall = base.labelSmall.copy(fontFamily = baloo, fontWeight = FontWeight.Bold),
    )
}
