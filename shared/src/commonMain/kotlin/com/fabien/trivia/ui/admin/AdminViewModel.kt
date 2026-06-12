package com.fabien.trivia.ui.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.PlayerAdminRepository
import com.fabien.trivia.data.QuestionRepository
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
    /** Seeding (push du set bundlé vers Firestore) en cours. */
    val isSeeding: Boolean = false,
    /** Nombre de questions poussées au dernier seed réussi (null tant qu'aucun seed). */
    val seededCount: Int? = null,
    /** Réinitialisation (suppression) de tous les joueurs en cours. */
    val isWiping: Boolean = false,
    /** Nombre de joueurs supprimés à la dernière réinitialisation (null tant qu'aucune). */
    val wipedCount: Int? = null,
    /** Incrémenté à chaque réinitialisation réussie → déclenche le reset local de l'admin côté UI. */
    val wipeTick: Int = 0,
    val error: String? = null
)

/**
 * ViewModel des outils d'administration (réservé au compte [com.fabien.trivia.ui.account.ADMIN_EMAIL]).
 * Pour l'instant : export de la collection Firestore `questions` en JSON.
 */
class AdminViewModel(
    private val questions: RemoteQuestionRepository = RemoteQuestionRepository(),
    private val playerAdmin: PlayerAdminRepository = PlayerAdminRepository()
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

    /**
     * Pousse (écrase par slug) le set bundlé `QuestionRepository.questions` vers Firestore.
     * Opération de maintenance ponctuelle (ex. après ajout de questions ou du champ `title`).
     * ⚠️ Nécessite des règles autorisant l'écriture sur `questions` (temporairement
     * `allow write: if request.auth != null`), et un compte connecté.
     */
    fun seedQuestions() {
        if (_state.value.isSeeding || _state.value.isBusy) return
        viewModelScope.launch {
            _state.value = _state.value.copy(isSeeding = true, seededCount = null, error = null)
            try {
                val all = QuestionRepository.questions
                questions.seed(all)
                _state.value = _state.value.copy(isSeeding = false, seededCount = all.size)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isSeeding = false, error = e.message ?: "Échec du seed")
            }
        }
    }

    /**
     * Réinitialise les données liées aux questions de TOUS les joueurs (ratings, séries, pool, stats,
     * historique) en **conservant les pseudos** → chaque joueur revient à l'état « compte neuf » côté cloud.
     * ⚠️ Nécessite une règle Firestore autorisant l'admin à lire/écrire n'importe quel doc `players`
     * (cf. [PlayerAdminRepository]). Le reset des données LOCALES de l'admin est déclenché côté UI via
     * [AdminUiState.wipeTick] ; les autres appareils doivent se reconnecter.
     */
    fun wipeAllPlayers() {
        if (_state.value.isWiping || _state.value.isBusy || _state.value.isSeeding) return
        viewModelScope.launch {
            _state.value = _state.value.copy(isWiping = true, wipedCount = null, error = null)
            try {
                val n = playerAdmin.resetAllPlayersData()
                _state.value = _state.value.copy(isWiping = false, wipedCount = n, wipeTick = _state.value.wipeTick + 1)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isWiping = false, error = e.message ?: "Échec de la réinitialisation")
            }
        }
    }
}
