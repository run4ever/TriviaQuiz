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
    val text: String,
    val options: List<String>,
    val correctIndex: Int,
    val rating: Int,
    val explanation: String,
    val category: Category
)
