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
    /**
     * Titre court (2-5 mots) résumant le sujet de la question SANS dévoiler la réponse. Sert de
     * libellé scannable (historique des questions, point 17) et d'index compact pour l'enrichissement.
     * Ex. « Capitale de l'Australie ». Ne jamais y mettre la bonne réponse.
     */
    val title: String,
    val text: String,
    val options: List<String>,
    val correctIndex: Int,
    val rating: Int,
    val explanation: String,
    val category: Category,
    /**
     * Mots-clés transverses pour regrouper des questions par thème (ex. `["capitale"]`), indépendamment
     * de la catégorie — sert aux « entrées directes » (filtre `array-contains` côté Firestore). Vide par
     * défaut. Pour les capitales, l'id (`geo_capitale_<pays>`) porte AUSSI l'info ; le tag la rend requêtable.
     */
    val tags: List<String> = emptyList()
)
