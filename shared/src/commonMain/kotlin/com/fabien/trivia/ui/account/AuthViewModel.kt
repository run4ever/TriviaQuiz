package com.fabien.trivia.ui.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.AuthRepository
import com.fabien.trivia.data.AuthUser
import com.fabien.trivia.data.UserProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AuthUiState(
    val user: AuthUser? = null,
    val pseudo: String = "",
    val avatarAnimal: String? = null,
    val avatarStyle: String? = null,
    val isBusy: Boolean = false,
    val error: String? = null,
    /** Message neutre/positif (ex. confirmation d'envoi du lien de réinitialisation), affiché en vert. */
    val info: String? = null
) {
    val isSignedIn: Boolean get() = user != null
    val isGuest: Boolean get() = user?.isAnonymous == true

    /** Vrai compte email (≠ invité anonyme) → écran « Mon compte » (maquette 9). */
    val isEmailUser: Boolean get() = user != null && user.isAnonymous == false

    /** Compte administrateur (Fabien) → débloque l'écran d'export Firestore. */
    val isAdmin: Boolean get() = user?.email?.equals(ADMIN_EMAIL, ignoreCase = true) == true
}

/** Email du seul compte autorisé à voir les outils d'administration (export Firestore). */
const val ADMIN_EMAIL = "fabien.laurette@gmail.com"

class AuthViewModel(
    private val repository: AuthRepository = AuthRepository(),
    private val profiles: UserProfileRepository = UserProfileRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(AuthUiState(user = repository.currentUser))
    val state: StateFlow<AuthUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.authState.collect { applyUser(it) }
        }
    }

    /**
     * Applique l'utilisateur courant à l'état + (re)charge son profil (pseudo + avatar) pour un compte
     * email ; sinon (invité anonyme ou déconnecté) on VIDE — sans ça, l'ancien pseudo/avatar restait
     * affiché après déconnexion.
     *
     * ⚠️ iOS : le `Flow` `authStateChanged` de GitLive ne ré-émet PAS de façon fiable après
     * `signIn`/`register`/`linkWithCredential` (l'UI restait bloquée en « mode invité » alors que le
     * compte était bien créé côté serveur). On ne peut donc pas dépendre que du listener : [launchAuth]
     * rappelle [applyUser] explicitement depuis `currentUser` après chaque action.
     */
    private suspend fun applyUser(user: AuthUser?) {
        if (user != null && !user.isAnonymous) {
            val profile = runCatching { profiles.getProfile(user.uid) }.getOrNull()
            _state.value = _state.value.copy(
                user = user,
                pseudo = profile?.pseudo.orEmpty(),
                avatarAnimal = profile?.avatarAnimal,
                avatarStyle = profile?.avatarStyle,
            )
        } else {
            _state.value = _state.value.copy(user = user, pseudo = "", avatarAnimal = null, avatarStyle = null)
        }
    }

    fun setPseudo(value: String) {
        _state.value = _state.value.copy(pseudo = value)
    }

    fun savePseudo() {
        val uid = _state.value.user?.uid ?: return
        val pseudo = _state.value.pseudo.trim()
        if (pseudo.isBlank()) return
        launchAuth { profiles.setPseudo(uid, pseudo) }
    }

    /** Enregistre l'avatar choisi (compte email) + maj de l'état → l'effet directory de App le propage aux amis. */
    fun setAvatar(animal: String, style: String) {
        val uid = _state.value.user?.uid ?: return
        _state.value = _state.value.copy(avatarAnimal = animal, avatarStyle = style)
        launchAuth { profiles.setAvatar(uid, animal, style) }
    }

    fun continueAsGuest() = launchAuth { repository.signInAnonymously() }
    fun signIn(email: String, password: String) = launchAuth { repository.signIn(email.trim(), password) }

    /** Crée un compte email + enregistre le pseudo (les 3 champs sont obligatoires côté UI). */
    fun register(email: String, password: String, pseudo: String) = launchAuth {
        repository.register(email.trim(), password)
        savePseudoFor(repository.currentUser?.uid, pseudo)
    }

    /** Convertit le compte invité en compte email (garde l'UID) + enregistre le pseudo. */
    fun linkEmail(email: String, password: String, pseudo: String) = launchAuth {
        repository.linkEmail(email.trim(), password)
        savePseudoFor(repository.currentUser?.uid, pseudo)
    }

    private suspend fun savePseudoFor(uid: String?, pseudo: String) {
        val p = pseudo.trim()
        if (uid != null && p.isNotEmpty()) profiles.setPseudo(uid, p)
    }

    fun signOut() = launchAuth { repository.signOut() }

    /**
     * Mot de passe oublié : déclenche l'email de réinitialisation Firebase pour [email].
     * Anti-énumération : on affiche le même message de confirmation, que le compte existe ou non.
     */
    fun sendPasswordReset(email: String) {
        val e = email.trim()
        when {
            e.isBlank() -> { _state.value = _state.value.copy(error = "Saisis ton adresse email d'abord.", info = null); return }
            !e.contains('@') || !e.substringAfter('@').contains('.') ->
                { _state.value = _state.value.copy(error = "Adresse email invalide.", info = null); return }
        }
        viewModelScope.launch {
            _state.value = _state.value.copy(isBusy = true, error = null, info = null)
            // Échec silencieux (compte inconnu, etc.) → on masque le détail et on affiche le même message.
            runCatching { repository.sendPasswordReset(e) }
            _state.value = _state.value.copy(
                isBusy = false,
                info = "Si un compte existe pour $e, un email de réinitialisation vient d'être envoyé. Pense à vérifier tes spams.",
            )
        }
    }

    fun clearError() {
        _state.value = _state.value.copy(error = null, info = null)
    }

    private fun launchAuth(block: suspend () -> Unit) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isBusy = true, error = null, info = null)
            try {
                block()
                // iOS : authStateChanged ne ré-émet pas après signIn/register/link → on rafraîchit
                // explicitement depuis currentUser (cf. docstring applyUser). Inoffensif sur Android.
                applyUser(repository.currentUser)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message ?: "Une erreur est survenue")
            } finally {
                _state.value = _state.value.copy(isBusy = false)
            }
        }
    }
}
