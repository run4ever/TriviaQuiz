package com.fabien.trivia.ui.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.RemoteQuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AdminUiState(
    val isBusy: Boolean = false,
    /** JSON du dernier export réussi (null tant qu'aucun export n'a été fait). */
    val export: String? = null,
    val count: Int = 0,
    /** Incrémenté à chaque export réussi → permet à l'UI de redéclencher la copie presse-papiers. */
    val exportTick: Int = 0,
    val error: String? = null
)

/**
 * ViewModel des outils d'administration (réservé au compte [com.fabien.trivia.ui.account.ADMIN_EMAIL]).
 * Pour l'instant : export de la collection Firestore `questions` en JSON.
 */
class AdminViewModel(
    private val questions: RemoteQuestionRepository = RemoteQuestionRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(AdminUiState())
    val state: StateFlow<AdminUiState> = _state.asStateFlow()

    fun exportQuestions() {
        if (_state.value.isBusy) return
        viewModelScope.launch {
            _state.value = AdminUiState(isBusy = true)
            try {
                val result = questions.exportAsJson()
                _state.value = AdminUiState(
                    export = result.json,
                    count = result.count,
                    exportTick = _state.value.exportTick + 1
                )
            } catch (e: Exception) {
                _state.value = AdminUiState(error = e.message ?: "Échec de l'export")
            }
        }
    }
}
