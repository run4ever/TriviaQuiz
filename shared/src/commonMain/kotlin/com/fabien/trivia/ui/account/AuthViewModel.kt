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
    fun register(email: String, password: String) = launchAuth { repository.register(email.trim(), password) }
    fun linkEmail(email: String, password: String) = launchAuth { repository.linkEmail(email.trim(), password) }
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
