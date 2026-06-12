package com.fabien.trivia.ui.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.fabien.trivia.ui.components.PseudoAvatar
import org.jetbrains.compose.resources.painterResource

/**
 * Affiche l'avatar d'un joueur : l'image Kenney du couple ([animal], [style]) si défini, **sinon l'avatar
 * par défaut `avatar_bear_round`** (donc jamais d'avatar vide, y compris pour les comptes créés avant cette
 * feature). Le placeholder [PseudoAvatar] ([pseudo]/[seed]) n'est qu'un ultime filet si même le défaut
 * était introuvable (ne devrait pas arriver).
 */
@Composable
fun Avatar(
    animal: String?,
    style: String?,
    pseudo: String,
    seed: String,
    size: Dp,
    modifier: Modifier = Modifier,
) {
    val res = avatarDrawable(animal, style) ?: avatarDrawable(DEFAULT_AVATAR_ANIMAL, DEFAULT_AVATAR_STYLE)
    if (res != null) {
        Image(
            painter = painterResource(res),
            contentDescription = null,
            modifier = modifier.size(size),
        )
    } else {
        PseudoAvatar(pseudo = pseudo, seed = seed, size = size, modifier = modifier)
    }
}
