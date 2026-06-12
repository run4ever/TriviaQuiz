package com.fabien.trivia.ui.friends

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fabien.trivia.data.DirectoryEntry
import com.fabien.trivia.ui.avatar.Avatar
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.TriviaPalette
import com.fabien.trivia.ui.theme.levelName

/**
 * Écran « Amis » (V1) : barre de recherche par pseudo en haut → résultats avec bouton « Ajouter » ;
 * sinon sélecteur de tri (Niveau par défaut / Pseudo) + liste des amis (avatar + pseudo + niveau).
 */
@Composable
fun FriendsScreen(
    modifier: Modifier = Modifier,
    state: FriendsUiState,
    onBack: () -> Unit,
    onSearch: (String) -> Unit,
    onSetSort: (FriendSort) -> Unit,
    onAdd: (DirectoryEntry) -> Unit,
    onRemove: (String) -> Unit,
) {
    val searching = state.query.isNotBlank()
    Column(
        modifier = modifier.fillMaxSize().background(TriviaPalette.bg)
    ) {
        Header(count = state.friends.size, onBack = onBack)

        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            Spacer(Modifier.height(12.dp))
            SearchField(value = state.query, onValueChange = onSearch)
            Spacer(Modifier.height(12.dp))
        }

        if (searching) {
            SearchResults(state = state, onAdd = onAdd)
        } else {
            SortSelector(sort = state.sort, onSetSort = onSetSort)
            Spacer(Modifier.height(10.dp))
            FriendsList(friends = state.sortedFriends, onRemove = onRemove)
        }
    }
}

// ── En-tête « ‹ Accueil » + « Amis (n) » ──────────────────────────────────
@Composable
private fun Header(count: Int, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 14.dp, top = 6.dp)) {
        Row(
            modifier = Modifier.clip(RoundedCornerShape(8.dp)).clickable(onClick = onBack).padding(horizontal = 6.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(AppIcons.ChevronLeft, contentDescription = null, tint = TriviaPalette.brand, modifier = Modifier.size(18.dp))
            Text("Accueil", style = MaterialTheme.typography.titleSmall, color = TriviaPalette.brand)
        }
        Text(
            text = if (count > 0) "Amis ($count)" else "Amis",
            style = MaterialTheme.typography.headlineSmall,
            color = TriviaPalette.ink,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 6.dp, top = 2.dp, bottom = 4.dp),
        )
    }
}

@Composable
private fun SearchField(value: String, onValueChange: (String) -> Unit) {
    val nunito = MaterialTheme.typography.bodyMedium.fontFamily
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TriviaPalette.ink),
        cursorBrush = SolidColor(TriviaPalette.brand),
        modifier = Modifier.fillMaxWidth(),
        decorationBox = { inner ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(TriviaPalette.card)
                    .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(14.dp))
                    .padding(horizontal = 13.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(9.dp),
            ) {
                Icon(AppIcons.Search, contentDescription = null, tint = TriviaPalette.inkFaint, modifier = Modifier.size(18.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(
                            "Rechercher un pseudo",
                            style = TextStyle(fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TriviaPalette.inkFaint),
                        )
                    }
                    inner()
                }
            }
        },
    )
}

@Composable
private fun SearchResults(state: FriendsUiState, onAdd: (DirectoryEntry) -> Unit) {
    if (state.results.isEmpty()) {
        EmptyText(if (state.isSearching) "Recherche…" else "Aucun joueur trouvé pour « ${state.query.trim()} ».")
        return
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(state.results, key = { it.uid }) { entry ->
            PersonRow(entry = entry) {
                val already = entry.uid in state.friendUids
                if (already) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(AppIcons.Check, contentDescription = null, tint = TriviaPalette.good, modifier = Modifier.size(16.dp))
                        Text("Ami", style = MaterialTheme.typography.labelMedium, color = TriviaPalette.good)
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(TriviaPalette.brand)
                            .clickable { onAdd(entry) }
                            .padding(horizontal = 12.dp, vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Icon(AppIcons.Plus, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                        Text("Ajouter", style = MaterialTheme.typography.labelMedium, color = Color.White)
                    }
                }
            }
        }
        item { Spacer(Modifier.height(10.dp)) }
    }
}

@Composable
private fun SortSelector(sort: FriendSort, onSetSort: (FriendSort) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(TriviaPalette.card)
            .border(1.5.dp, TriviaPalette.line, RoundedCornerShape(14.dp))
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        SortTab("Niveau", active = sort == FriendSort.LEVEL, modifier = Modifier.weight(1f)) { onSetSort(FriendSort.LEVEL) }
        SortTab("Pseudo", active = sort == FriendSort.PSEUDO, modifier = Modifier.weight(1f)) { onSetSort(FriendSort.PSEUDO) }
    }
}

@Composable
private fun SortTab(label: String, active: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(11.dp))
            .background(if (active) TriviaPalette.brand else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(vertical = 9.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            label,
            style = MaterialTheme.typography.titleSmall,
            color = if (active) Color.White else TriviaPalette.inkSoft,
            fontWeight = FontWeight.ExtraBold,
        )
    }
}

@Composable
private fun FriendsList(friends: List<DirectoryEntry>, onRemove: (String) -> Unit) {
    if (friends.isEmpty()) {
        EmptyText("Aucun ami pour l'instant. Cherche un pseudo ci-dessus pour en ajouter.")
        return
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(friends, key = { it.uid }) { entry ->
            PersonRow(entry = entry) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .clickable { onRemove(entry.uid) }
                        .padding(6.dp),
                ) {
                    Icon(AppIcons.Close, contentDescription = "Retirer", tint = TriviaPalette.inkFaint, modifier = Modifier.size(18.dp))
                }
            }
        }
        item { Spacer(Modifier.height(10.dp)) }
    }
}

/** Ligne « personne » : avatar + pseudo + niveau, avec une action à droite (slot). */
@Composable
private fun PersonRow(entry: DirectoryEntry, trailing: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(TriviaPalette.card)
            .padding(horizontal = 12.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Avatar(animal = entry.avatarAnimal, style = entry.avatarStyle, pseudo = entry.pseudo, seed = entry.uid, size = 46.dp)
        Column(modifier = Modifier.weight(1f)) {
            Text(
                entry.pseudo.ifBlank { "Joueur" },
                style = MaterialTheme.typography.titleSmall,
                color = TriviaPalette.ink,
                fontWeight = FontWeight.ExtraBold,
            )
            Spacer(Modifier.height(2.dp))
            Text(
                "${entry.rating.levelName()} · ${entry.rating} pts",
                style = MaterialTheme.typography.bodyMedium,
                color = TriviaPalette.inkSoft,
                fontSize = 12.sp,
            )
        }
        trailing()
    }
}

@Composable
private fun EmptyText(text: String) {
    Text(
        text,
        style = MaterialTheme.typography.bodyMedium,
        color = TriviaPalette.inkSoft,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 22.dp, vertical = 28.dp),
    )
}
