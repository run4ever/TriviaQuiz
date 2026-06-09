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
    val isBusy: Boolean = false,
    val error: String? = null
) {
    val isSignedIn: Boolean get() = user != null
    val isGuest: Boolean get() = user?.isAnonymous == true
}

class AuthViewModel(
    private val repository: AuthRepository = AuthRepository(),
    private val profiles: UserProfileRepository = UserProfileRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(AuthUiState(user = repository.currentUser))
    val state: StateFlow<AuthUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.authState.collect { user ->
                _state.value = _state.value.copy(user = user)
                // Charge le pseudo enregistré pour un compte (pas pour un invité anonyme).
                if (user != null && !user.isAnonymous) {
                    val pseudo = runCatching { profiles.getPseudo(user.uid) }.getOrNull().orEmpty()
                    _state.value = _state.value.copy(pseudo = pseudo)
                }
            }
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

    fun clearError() {
        _state.value = _state.value.copy(error = null)
    }

    private fun launchAuth(block: suspend () -> Unit) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isBusy = true, error = null)
            try {
                block()
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message ?: "Une erreur est survenue")
            } finally {
                _state.value = _state.value.copy(isBusy = false)
            }
        }
    }
}
