package com.fabien.trivia.ui.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

/**
 * Écran de gestion du compte (optionnel). Trois états selon [state] :
 * - déconnecté : formulaire connexion / inscription + « continuer en invité »
 * - invité (anonyme) : invite à créer un vrai compte (lien) + déconnexion
 * - connecté (email) : affiche l'email + déconnexion
 */
@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    state: AuthUiState,
    onSignIn: (String, String) -> Unit,
    onRegister: (email: String, password: String, pseudo: String) -> Unit,
    onContinueAsGuest: () -> Unit,
    onLinkEmail: (email: String, password: String, pseudo: String) -> Unit,
    onSignOut: () -> Unit,
    onBack: () -> Unit,
    onPseudoChange: (String) -> Unit = {},
    onSavePseudo: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        TextButton(onClick = onBack) {
            Text("< Profil", style = MaterialTheme.typography.labelLarge)
        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Compte",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(24.dp))

        val user = state.user
        when {
            user == null -> SignedOutContent(state, onSignIn, onRegister, onContinueAsGuest)
            user.isAnonymous -> GuestContent(state, onLinkEmail, onSignOut)
            else -> SignedInContent(
                email = user.email,
                pseudo = state.pseudo,
                isBusy = state.isBusy,
                onPseudoChange = onPseudoChange,
                onSavePseudo = onSavePseudo,
                onSignOut = onSignOut
            )
        }

        if (state.error != null) {
            Spacer(Modifier.height(16.dp))
            Text(
                text = state.error,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error
            )
        }

        if (state.isBusy) {
            Spacer(Modifier.height(16.dp))
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun ColumnScope.SignedOutContent(
    state: AuthUiState,
    onSignIn: (String, String) -> Unit,
    onRegister: (String, String, String) -> Unit,
    onContinueAsGuest: () -> Unit
) {
    var registerMode by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pseudo by remember { mutableStateOf("") }
    var pseudoEdited by remember { mutableStateOf(false) }

    EmailPasswordFields(
        email = email,
        password = password,
        onEmailChange = {
            email = it
            // Tant que l'utilisateur n'a pas touché au pseudo, on le suggère depuis l'email.
            if (registerMode && !pseudoEdited) pseudo = it.substringBefore("@")
        },
        onPasswordChange = { password = it }
    )

    if (registerMode) {
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = pseudo,
            onValueChange = { pseudo = it; pseudoEdited = true },
            label = { Text("Pseudo") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

    Spacer(Modifier.height(16.dp))

    Button(
        onClick = { if (registerMode) onRegister(email, password, pseudo) else onSignIn(email, password) },
        modifier = Modifier.fillMaxWidth(),
        enabled = !state.isBusy && email.isNotBlank() && password.isNotBlank() &&
            (!registerMode || pseudo.isNotBlank())
    ) {
        Text(if (registerMode) "Créer un compte" else "Se connecter")
    }

    TextButton(
        onClick = {
            registerMode = !registerMode
            if (registerMode && !pseudoEdited) pseudo = email.substringBefore("@")
        },
        modifier = Modifier.align(Alignment.CenterHorizontally)
    ) {
        Text(
            if (registerMode) "J'ai déjà un compte — Se connecter"
            else "Pas de compte ? Créer un compte"
        )
    }

    Spacer(Modifier.height(8.dp))

    OutlinedButton(
        onClick = onContinueAsGuest,
        modifier = Modifier.fillMaxWidth(),
        enabled = !state.isBusy
    ) {
        Text("Continuer en invité")
    }
}

@Composable
private fun ColumnScope.GuestContent(
    state: AuthUiState,
    onLinkEmail: (String, String, String) -> Unit,
    onSignOut: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pseudo by remember { mutableStateOf("") }
    var pseudoEdited by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "Vous jouez en mode invité",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Créez un compte pour sauvegarder votre progression et la retrouver sur un autre appareil.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }

    Spacer(Modifier.height(16.dp))

    EmailPasswordFields(
        email = email,
        password = password,
        onEmailChange = {
            email = it
            if (!pseudoEdited) pseudo = it.substringBefore("@")
        },
        onPasswordChange = { password = it }
    )

    Spacer(Modifier.height(8.dp))
    OutlinedTextField(
        value = pseudo,
        onValueChange = { pseudo = it; pseudoEdited = true },
        label = { Text("Pseudo") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(Modifier.height(16.dp))

    Button(
        onClick = { onLinkEmail(email, password, pseudo) },
        modifier = Modifier.fillMaxWidth(),
        enabled = !state.isBusy && email.isNotBlank() && password.isNotBlank() && pseudo.isNotBlank()
    ) {
        Text("Créer mon compte")
    }

    Spacer(Modifier.height(8.dp))

    TextButton(
        onClick = onSignOut,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        enabled = !state.isBusy
    ) {
        Text("Se déconnecter")
    }
}

@Composable
private fun SignedInContent(
    email: String?,
    pseudo: String,
    isBusy: Boolean,
    onPseudoChange: (String) -> Unit,
    onSavePseudo: () -> Unit,
    onSignOut: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(24.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Connecté",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = email ?: "—",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

    Spacer(Modifier.height(16.dp))

    // Pseudo (nom affiché en multijoueur). Pas d'unicité, l'email reste la clé du compte.
    OutlinedTextField(
        value = pseudo,
        onValueChange = onPseudoChange,
        label = { Text("Pseudo (affiché en multijoueur)") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(Modifier.height(8.dp))
    Button(
        onClick = onSavePseudo,
        modifier = Modifier.fillMaxWidth(),
        enabled = !isBusy && pseudo.isNotBlank()
    ) {
        Text("Enregistrer le pseudo")
    }

    Spacer(Modifier.height(16.dp))

    OutlinedButton(onClick = onSignOut, modifier = Modifier.fillMaxWidth()) {
        Text("Se déconnecter")
    }
}

@Composable
private fun EmailPasswordFields(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(Modifier.height(8.dp))
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Mot de passe") },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth()
    )
}
