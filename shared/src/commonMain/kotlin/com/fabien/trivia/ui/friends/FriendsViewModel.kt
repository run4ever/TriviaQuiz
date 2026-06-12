package com.fabien.trivia.ui.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.DirectoryEntry
import com.fabien.trivia.data.DirectoryRepository
import com.fabien.trivia.data.FriendsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/** Tri de la liste d'amis. Niveau (points décroissants) par défaut. */
enum class FriendSort { LEVEL, PSEUDO }

data class FriendsUiState(
    val uid: String? = null,
    val friends: List<DirectoryEntry> = emptyList(),
    val friendUids: Set<String> = emptySet(),
    val sort: FriendSort = FriendSort.LEVEL,
    val query: String = "",
    val results: List<DirectoryEntry> = emptyList(),
    val isLoading: Boolean = false,
    val isSearching: Boolean = false,
    val error: String? = null,
) {
    /** Amis triés selon [sort]. */
    val sortedFriends: List<DirectoryEntry>
        get() = when (sort) {
            FriendSort.LEVEL -> friends.sortedWith(compareByDescending<DirectoryEntry> { it.rating }.thenBy { it.pseudo.lowercase() })
            FriendSort.PSEUDO -> friends.sortedBy { it.pseudo.lowercase() }
        }
}

/**
 * ViewModel de la fonctionnalité Amis (V1, modèle follow). Charge mes amis (`friends` → `directory`),
 * gère la recherche par pseudo, le tri, l'ajout/retrait. Réservé aux comptes email (piloté par [uid]).
 */
class FriendsViewModel(
    private val directory: DirectoryRepository = DirectoryRepository(),
    private val friends: FriendsRepository = FriendsRepository(),
) : ViewModel() {

    private val _state = MutableStateFlow(FriendsUiState())
    val state: StateFlow<FriendsUiState> = _state.asStateFlow()

    /** Connexion/déconnexion : recharge (ou vide) la liste d'amis et réinitialise la recherche. */
    fun onUserChanged(uid: String?) {
        _state.value = _state.value.copy(uid = uid, query = "", results = emptyList(), error = null)
        if (uid == null) {
            _state.value = _state.value.copy(friends = emptyList(), friendUids = emptySet())
            return
        }
        loadFriends(uid)
    }

    private fun loadFriends(uid: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val uids = friends.friendUids(uid)
                val entries = directory.getMany(uids)
                _state.value = _state.value.copy(friends = entries, friendUids = uids.toSet(), isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    /** Met à jour MA fiche publique (pseudo + rating). À appeler à la connexion / au changement de pseudo. */
    fun updateMyDirectory(uid: String, pseudo: String, rating: Int) {
        if (pseudo.isBlank()) return
        viewModelScope.launch { runCatching { directory.upsert(uid, pseudo, rating) } }
    }

    fun setSort(sort: FriendSort) {
        _state.value = _state.value.copy(sort = sort)
    }

    fun search(query: String) {
        _state.value = _state.value.copy(query = query)
        val uid = _state.value.uid ?: return
        if (query.trim().isEmpty()) {
            _state.value = _state.value.copy(results = emptyList(), isSearching = false)
            return
        }
        viewModelScope.launch {
            _state.value = _state.value.copy(isSearching = true)
            try {
                val res = directory.search(query, excludeUid = uid)
                // Résultat ignoré si la saisie a changé entre-temps (évite l'affichage d'un résultat périmé).
                if (_state.value.query == query) {
                    _state.value = _state.value.copy(results = res, isSearching = false)
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(isSearching = false, error = e.message)
            }
        }
    }

    /** Ajoute un ami (follow) + mise à jour optimiste de l'état local. */
    fun addFriend(entry: DirectoryEntry) {
        val uid = _state.value.uid ?: return
        if (entry.uid in _state.value.friendUids) return
        viewModelScope.launch { runCatching { friends.add(uid, entry.uid) } }
        _state.value = _state.value.copy(
            friendUids = _state.value.friendUids + entry.uid,
            friends = (_state.value.friends + entry).distinctBy { it.uid },
        )
    }

    /** Retire un ami + mise à jour optimiste. */
    fun removeFriend(friendUid: String) {
        val uid = _state.value.uid ?: return
        viewModelScope.launch { runCatching { friends.remove(uid, friendUid) } }
        _state.value = _state.value.copy(
            friendUids = _state.value.friendUids - friendUid,
            friends = _state.value.friends.filterNot { it.uid == friendUid },
        )
    }
}
