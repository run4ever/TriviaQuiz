package com.fabien.trivia.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabien.trivia.ui.components.ChunkyButton
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette

/**
 * Écran « Compte » (refonte Vitamine, maquettes 8 & 9). Un seul composable, deux branches :
 * - invité / déconnecté ([AuthUiState.isEmailUser] == false) → maquette 8 : connexion / inscription.
 * - compte email ([AuthUiState.isEmailUser] == true) → maquette 9 : mon compte (pseudo + déconnexion).
 *
 * L'« invité » est un compte anonyme Firebase (créé au démarrage / par le multijoueur). Sur l'écran 8,
 * [onSignUp] est appelé pour S'inscrire : côté App on appelle `linkEmail` si l'utilisateur est anonyme
 * (on conserve l'UID et la progression déjà synchronisée), sinon `register`.
 */
private enum class AuthMode { SignIn, SignUp }

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    state: AuthUiState,
    onSignIn: (email: String, password: String) -> Unit,
    onSignUp: (email: String, password: String, pseudo: String) -> Unit,
    onSavePseudo: (String) -> Unit,
    onSignOut: () -> Unit,
    onBack: () -> Unit,
    isAdmin: Boolean = false,
    onOpenAdmin: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TriviaPalette.bg)
            .imePadding()
    ) {
        AcctHeader(onBack = onBack)
        if (state.isEmailUser) {
            SignedInContent(
                email = state.user?.email,
                pseudo = state.pseudo,
                isBusy = state.isBusy,
                error = state.error,
                onSavePseudo = onSavePseudo,
                onSignOut = onSignOut,
                isAdmin = isAdmin,
                onOpenAdmin = onOpenAdmin,
            )
        } else {
            AuthContent(
                isBusy = state.isBusy,
                error = state.error,
                onSignIn = onSignIn,
                onSignUp = onSignUp,
            )
        }
    }
}

// ── En-tête commun : « ‹ Profil » + titre « Compte » centré ───────────────
@Composable
private fun AcctHeader(onBack: () -> Unit) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    Column(modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp, top = 4.dp)) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onBack)
                .padding(horizontal = 6.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(AppIcons.ChevronLeft, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(18.dp))
            Text(
                "Profil",
                style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TriviaPalette.brand),
            )
        }
        Text(
            "Compte",
            style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 23.sp, color = TriviaPalette.ink),
            modifier = Modifier.fillMaxWidth(),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        )
    }
}

// ════════════════════════════════════════════════════════════════════════
// 8 · Connexion / inscription (invité + déconnecté fusionnés)
// ════════════════════════════════════════════════════════════════════════
@Composable
private fun ColumnScope.AuthContent(
    isBusy: Boolean,
    error: String?,
    onSignIn: (String, String) -> Unit,
    onSignUp: (String, String, String) -> Unit,
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    var mode by remember { mutableStateOf(AuthMode.SignUp) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pseudo by remember { mutableStateOf("") }
    var pseudoEdited by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    val signUp = mode == AuthMode.SignUp
    val canSubmit = !isBusy && email.isNotBlank() && password.isNotBlank() && (!signUp || pseudo.isNotBlank())

    Column(
        modifier = Modifier.fillMaxWidth().weight(1f).padding(start = 18.dp, end = 18.dp, top = 12.dp, bottom = 6.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        GuestCard()

        // Segmented : Se connecter | S'inscrire
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(TriviaPalette.card, RoundedCornerShape(16.dp))
                .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(16.dp))
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            SegmentTab("Se connecter", active = !signUp, baloo = baloo, modifier = Modifier.weight(1f)) { mode = AuthMode.SignIn }
            SegmentTab("S'inscrire", active = signUp, baloo = baloo, modifier = Modifier.weight(1f)) { mode = AuthMode.SignUp }
        }

        // Formulaire : email → pseudo (inscription) → mot de passe
        Column(verticalArrangement = Arrangement.spacedBy(13.dp)) {
            AccountField(
                icon = AppIcons.Mail,
                label = "Email",
                value = email,
                onValueChange = {
                    email = it
                    if (signUp && !pseudoEdited) pseudo = it.substringBefore("@")
                },
                placeholder = "ton@email.com",
                keyboardType = KeyboardType.Email,
            )
            if (signUp) {
                PseudoField(
                    value = pseudo,
                    onValueChange = { pseudo = it; pseudoEdited = true },
                    helper = "Pré-rempli depuis ton email — modifiable.",
                )
            }
            AccountField(
                icon = AppIcons.Lock,
                label = "Mot de passe",
                value = password,
                onValueChange = { password = it },
                placeholder = "••••••••",
                keyboardType = KeyboardType.Password,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailing = {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { passwordVisible = !passwordVisible }
                            .padding(6.dp),
                    ) {
                        Icon(AppIcons.Eye, contentDescription = null, tint = TriviaPalette.inkFaint, modifier = Modifier.size(19.dp))
                    }
                },
            )
        }

        if (error != null) {
            Text(
                error,
                style = MaterialTheme.typography.bodyMedium,
                color = TriviaPalette.bad,
            )
        }

        Spacer(Modifier.weight(1f))

        ChunkyButton(
            onClick = {
                if (signUp) onSignUp(email.trim(), password, pseudo.trim()) else onSignIn(email.trim(), password)
            },
            color = if (canSubmit) TriviaPalette.brand else TriviaPalette.inkFaint,
            deep = if (canSubmit) TriviaPalette.brandDeep else TriviaPalette.inkSoft,
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            CenteredButtonLabel(
                icon = AppIcons.Sparkle,
                text = if (signUp) "Créer un compte" else "Se connecter",
                baloo = baloo,
            )
        }
    }
}

@Composable
private fun SegmentTab(
    label: String,
    active: Boolean,
    baloo: FontFamily?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (active) TriviaPalette.brand else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(vertical = 11.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            label,
            style = TextStyle(
                fontFamily = baloo,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 15.sp,
                color = if (active) Color.White else TriviaPalette.inkSoft,
            ),
        )
    }
}

// Carte « mode invité » (dégradé lilas)
@Composable
private fun GuestCard() {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Brush.linearGradient(listOf(Color(0xFFEFE9FF), Color(0xFFF7F3FF))))
            .border(1.5.dp, Color(0xFFE4DBFF), RoundedCornerShape(20.dp))
            .padding(horizontal = 15.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp),
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(Brush.linearGradient(listOf(TriviaPalette.brand, Color(0xFF9B7DFF)))),
            contentAlignment = Alignment.Center,
        ) {
            Icon(AppIcons.Cloud, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                "Vous jouez en mode invité",
                style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 15.5.sp, color = TriviaPalette.ink),
            )
            Spacer(Modifier.height(3.dp))
            Text(
                "Créez un compte pour sauvegarder votre progression et la retrouver sur tous vos appareils.",
                style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 12.5.sp, color = TriviaPalette.inkSoft),
            )
        }
    }
}

// ════════════════════════════════════════════════════════════════════════
// 9 · Mon compte (connecté)
// ════════════════════════════════════════════════════════════════════════
@Composable
private fun ColumnScope.SignedInContent(
    email: String?,
    pseudo: String,
    isBusy: Boolean,
    error: String?,
    onSavePseudo: (String) -> Unit,
    onSignOut: () -> Unit,
    isAdmin: Boolean,
    onOpenAdmin: () -> Unit,
) {
    val baloo = MaterialTheme.typography.titleMedium.fontFamily
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    var pseudoInput by remember(pseudo) { mutableStateOf(pseudo) }

    Column(
        modifier = Modifier.fillMaxWidth().weight(1f).padding(start = 18.dp, end = 18.dp, top = 14.dp, bottom = 6.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // Carte compte connecté
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(TriviaPalette.card)
                .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(20.dp))
                .padding(horizontal = 16.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(13.dp),
        ) {
            val initial = (pseudo.firstOrNull() ?: email?.firstOrNull())?.uppercaseChar()?.toString() ?: "?"
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Brush.linearGradient(listOf(TriviaPalette.brand, Color(0xFFEC4899)))),
                contentAlignment = Alignment.Center,
            ) {
                Text(initial, style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp, color = Color.White))
            }
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(TriviaPalette.goodTint)
                        .padding(horizontal = 9.dp, vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    Icon(AppIcons.Check, contentDescription = null, tint = TriviaPalette.good, modifier = Modifier.size(12.dp))
                    Text(
                        "Connecté",
                        style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 10.5.sp, color = TriviaPalette.good, letterSpacing = 0.3.sp),
                    )
                }
                Spacer(Modifier.height(3.dp))
                Text(
                    email ?: "—",
                    style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp, color = TriviaPalette.ink),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

        // Pseudo éditable + Enregistrer
        Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
            PseudoField(
                value = pseudoInput,
                onValueChange = { pseudoInput = it },
                helper = "Ton nom affiché en multijoueur.",
            )
            val canSave = !isBusy && pseudoInput.isNotBlank() && pseudoInput.trim() != pseudo
            ChunkyButton(
                onClick = { onSavePseudo(pseudoInput.trim()) },
                color = if (canSave) TriviaPalette.brand else TriviaPalette.inkFaint,
                deep = if (canSave) TriviaPalette.brandDeep else TriviaPalette.inkSoft,
                shape = RoundedCornerShape(15.dp),
                depth = 6.dp,
                modifier = Modifier.fillMaxWidth(),
            ) {
                CenteredButtonLabel(icon = AppIcons.Check, text = "Enregistrer le pseudo", baloo = baloo)
            }
        }

        // Note synchro
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(TriviaPalette.card)
                .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(15.dp))
                .padding(horizontal = 14.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(9.dp),
        ) {
            Icon(AppIcons.Shield, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(18.dp).padding(top = 1.dp))
            Text(
                "Ta progression et tes niveaux sont sauvegardés sur ce compte.",
                style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 12.5.sp, color = TriviaPalette.inkSoft),
            )
        }

        if (error != null) {
            Text(error, style = MaterialTheme.typography.bodyMedium, color = TriviaPalette.bad)
        }

        // Outils d'administration (réservé au compte admin) : export Firestore.
        if (isAdmin) {
            ChunkyButton(
                onClick = onOpenAdmin,
                color = TriviaPalette.night,
                deep = Color(0xFF000000),
                shape = RoundedCornerShape(15.dp),
                depth = 6.dp,
                modifier = Modifier.fillMaxWidth(),
            ) {
                CenteredButtonLabel(icon = AppIcons.Share, text = "Admin — Exporter les questions", baloo = baloo)
            }
        }

        Spacer(Modifier.weight(1f))

        // Déconnexion (bouton contour, texte rouge)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(TriviaPalette.card)
                .border(2.dp, TriviaPalette.line, RoundedCornerShape(16.dp))
                .clickable(enabled = !isBusy, onClick = onSignOut),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(AppIcons.Logout, contentDescription = null, tint = TriviaPalette.bad, modifier = Modifier.size(18.dp))
            Spacer(Modifier.size(9.dp))
            Text(
                "Se déconnecter",
                style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TriviaPalette.bad),
            )
        }
    }
}

// ── Champ de saisie « Compte » (icône + label + valeur, halo violet en focus) ──
@Composable
private fun AccountField(
    icon: ImageVector,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    accent: Color = TriviaPalette.brand,
    trailing: (@Composable () -> Unit)? = null,
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
            textStyle = TextStyle(fontFamily = nunito, fontWeight = FontWeight.ExtraBold, fontSize = 15.5.sp, color = TriviaPalette.ink),
            cursorBrush = SolidColor(accent),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = visualTransformation,
            decorationBox = { inner ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .background(Color.White, shape)
                        .then(if (focused) Modifier.border(4.dp, accent.copy(alpha = 0.13f), shape) else Modifier)
                        .border(1.5.dp, if (focused) accent else TriviaPalette.line, shape)
                        .padding(start = 13.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Icon(icon, contentDescription = null, tint = if (focused) accent else TriviaPalette.inkFaint, modifier = Modifier.size(19.dp))
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty() && placeholder.isNotEmpty()) {
                            Text(
                                placeholder,
                                style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 15.5.sp, color = TriviaPalette.inkFaint),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                        inner()
                    }
                    trailing?.invoke()
                }
            },
        )
    }
}

// Pseudo : AccountField + ligne d'aide (✦ helper)
@Composable
private fun PseudoField(
    value: String,
    onValueChange: (String) -> Unit,
    helper: String,
) {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    Column {
        AccountField(icon = AppIcons.User, label = "Pseudo", value = value, onValueChange = onValueChange)
        Row(
            modifier = Modifier.padding(start = 2.dp, top = 7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Icon(AppIcons.Sparkle, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(13.dp))
            Text(
                helper,
                style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 11.5.sp, color = TriviaPalette.inkSoft),
            )
        }
    }
}

// Libellé de bouton chunky centré (icône + texte)
@Composable
private fun androidx.compose.foundation.layout.RowScope.CenteredButtonLabel(
    icon: ImageVector,
    text: String,
    baloo: FontFamily?,
) {
    Row(
        modifier = Modifier.weight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
        Spacer(Modifier.size(10.dp))
        Text(
            text,
            style = TextStyle(fontFamily = baloo, fontWeight = FontWeight.Bold, fontSize = 17.sp, color = Color.White),
        )
    }
}
