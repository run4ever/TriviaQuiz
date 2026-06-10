package com.fabien.trivia.ui.admin

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette
import kotlinx.coroutines.delay

/**
 * Écran d'administration (réservé au compte [com.fabien.trivia.ui.account.ADMIN_EMAIL]).
 * Un seul bouton : exporte la collection Firestore `questions` en JSON et la copie dans le
 * presse-papiers — destiné à être collé dans un chat IA pour faire générer de nouvelles questions.
 */
@Composable
fun AdminExportScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    viewModel: AdminViewModel = viewModel { AdminViewModel() }
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    val state by viewModel.state.collectAsState()
    val clipboard = LocalClipboardManager.current
    var copied by remember { mutableStateOf(false) }

    // À chaque export réussi : copie le JSON et affiche un retour « copié » pendant 2,5 s.
    LaunchedEffect(state.exportTick) {
        if (state.exportTick > 0) {
            state.export?.let { clipboard.setText(AnnotatedString(it)) }
            copied = true
            delay(2500)
            copied = false
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
    ) {
        // En-tête « ‹ Compte » + titre centré
        Column(modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp, top = 4.dp)) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = onBack)
                    .padding(horizontal = 6.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(AppIcons.ChevronLeft, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(18.dp))
                Text(
                    "Compte",
                    style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TriviaPalette.brand)
                )
            }
            Text(
                "Admin",
                style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 23.sp, color = TriviaPalette.ink),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(start = 18.dp, end = 18.dp, top = 16.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Carte explicative
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(TriviaPalette.card)
                    .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(20.dp))
                    .padding(horizontal = 16.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(13.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(TriviaPalette.brand),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(AppIcons.Cloud, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Export des questions",
                        style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 15.5.sp, color = TriviaPalette.ink)
                    )
                    Spacer(Modifier.height(3.dp))
                    Text(
                        "Copie toute la collection Firestore « questions » au format JSON dans le presse-papiers. " +
                            "À coller dans une IA pour lui demander d'en générer de nouvelles.",
                        style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 12.5.sp, color = TriviaPalette.inkSoft)
                    )
                }
            }

            // Retour d'état (succès / erreur)
            when {
                copied -> StatusRow(
                    icon = AppIcons.Check,
                    tint = TriviaPalette.good,
                    bg = TriviaPalette.goodTint,
                    text = "${state.count} question(s) copiée(s) dans le presse-papiers.",
                    nunito = nunito
                )
                state.error != null -> StatusRow(
                    icon = AppIcons.Close,
                    tint = TriviaPalette.bad,
                    bg = TriviaPalette.badTint,
                    text = state.error ?: "",
                    nunito = nunito
                )
            }

            Spacer(Modifier.weight(1f))

            ChunkyButton(
                onClick = viewModel::exportQuestions,
                color = if (state.isBusy) TriviaPalette.inkFaint else TriviaPalette.brand,
                deep = if (state.isBusy) TriviaPalette.inkSoft else TriviaPalette.brandDeep,
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(AppIcons.Share, contentDescription = null, tint = Color.White, modifier = Modifier.size(21.dp))
                    Spacer(Modifier.size(10.dp))
                    Text(
                        if (state.isBusy) "Export en cours…" else "Exporter les questions (JSON)",
                        style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 17.sp, color = Color.White)
                    )
                }
            }
        }
    }
}

@Composable
private fun StatusRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    tint: Color,
    bg: Color,
    text: String,
    nunito: androidx.compose.ui.text.font.FontFamily?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(bg)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(18.dp))
        Text(
            text,
            style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = tint)
        )
    }
}
