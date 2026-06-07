package com.fabien.trivia.data

enum class Category {
    GEOGRAPHIE,
    HISTOIRE,
    SCIENCES_ET_NATURE,
    ART_ET_CULTURE,
    SPORTS,
    DIVERTISSEMENT
}

val Category.displayName: String
    get() = when (this) {
        Category.GEOGRAPHIE -> "Géographie"
        Category.HISTOIRE -> "Histoire"
        Category.SCIENCES_ET_NATURE -> "Sciences & Nature"
        Category.ART_ET_CULTURE -> "Art & Culture"
        Category.SPORTS -> "Sports"
        Category.DIVERTISSEMENT -> "Divertissement"
    }

data class Question(
    /**
     * Identifiant stable et permanent (slug), clé de l'historique anti-grind, du rating dynamique
     * et — à terme — du backend (document Firestore). Une fois posé, ne jamais le modifier, même
     * si l'énoncé ou l'image changent. Convention : `<prefixe_categorie>_<descripteur>`.
     */
    val id: String,
    val text: String,
    val options: List<String>,
    val correctIndex: Int,
    val rating: Int,
    val explanation: String,
    val category: Category
)
