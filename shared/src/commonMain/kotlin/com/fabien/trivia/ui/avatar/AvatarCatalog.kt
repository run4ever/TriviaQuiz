package com.fabien.trivia.ui.avatar

import org.jetbrains.compose.resources.DrawableResource

/**
 * Catalogue d'avatars (pack Kenney « Animal Pack Remastered », CC0). 30 animaux × 8 styles → fichiers
 * `composeResources/drawable/avatar_{animal}_{style}.png`. L'avatar d'un joueur = un couple (animal, style)
 * stocké dans `players/{uid}` et `directory/{uid}`.
 */
val AVATAR_ANIMALS = listOf(
    "bear", "buffalo", "chick", "chicken", "cow", "crocodile", "dog", "duck", "elephant", "frog",
    "giraffe", "goat", "gorilla", "hippo", "horse", "monkey", "moose", "narwhal", "owl", "panda",
    "parrot", "penguin", "pig", "rabbit", "rhino", "sloth", "snake", "walrus", "whale", "zebra",
)

/** Les 8 styles : id (= suffixe de fichier) → libellé FR (pour le sélecteur). */
val AVATAR_STYLES = listOf(
    "round" to "Rond",
    "round_outline" to "Rond avec contour",
    "round_without_details" to "Rond épuré",
    "round_without_details_outline" to "Rond épuré avec contour",
    "square" to "Carré",
    "square_outline" to "Carré avec contour",
    "square_without_details" to "Carré épuré",
    "square_without_details_outline" to "Carré épuré avec contour",
)

/** Avatar par défaut (invité, ou tout compte n'ayant pas encore choisi) : ours rond. */
const val DEFAULT_AVATAR_ANIMAL = "bear"
const val DEFAULT_AVATAR_STYLE = "round"

/** Nom FR de chaque animal (affiché au survol / sous l'aperçu dans le picker). */
val AVATAR_ANIMAL_NAMES: Map<String, String> = mapOf(
    "bear" to "Ours", "buffalo" to "Buffle", "chick" to "Poussin", "chicken" to "Poule",
    "cow" to "Vache", "crocodile" to "Crocodile", "dog" to "Chien", "duck" to "Canard",
    "elephant" to "Éléphant", "frog" to "Grenouille", "giraffe" to "Girafe", "goat" to "Chèvre",
    "gorilla" to "Gorille", "hippo" to "Hippopotame", "horse" to "Cheval", "monkey" to "Singe",
    "moose" to "Élan", "narwhal" to "Narval", "owl" to "Hibou", "panda" to "Panda",
    "parrot" to "Perroquet", "penguin" to "Manchot", "pig" to "Cochon", "rabbit" to "Lapin",
    "rhino" to "Rhinocéros", "sloth" to "Paresseux", "snake" to "Serpent", "walrus" to "Morse",
    "whale" to "Baleine", "zebra" to "Zèbre",
)

/** Nom affichable d'un animal (FR si connu, sinon l'id capitalisé). */
fun animalName(id: String): String = AVATAR_ANIMAL_NAMES[id] ?: id.replaceFirstChar { it.uppercase() }

/** Résout (animal, style) → ressource drawable (via [AVATAR_DRAWABLES]), ou null si absent/non défini. */
fun avatarDrawable(animal: String?, style: String?): DrawableResource? {
    if (animal.isNullOrBlank() || style.isNullOrBlank()) return null
    return AVATAR_DRAWABLES["avatar_${animal}_${style}"]
}
