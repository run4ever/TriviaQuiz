package com.fabien.trivia.data

class RatingsRepository(database: TriviaDatabase) {
    private val queries: RatingsQueries = database.ratingsQueries

    fun getPlayerRating(): Int =
        queries.getRating("global").executeAsOneOrNull()?.toInt() ?: 750

    fun getCategoryRating(category: Category): Int =
        queries.getRating(category.name).executeAsOneOrNull()?.toInt() ?: 750

    fun getAllCategoryRatings(): Map<Category, Int> =
        Category.entries.associateWith { getCategoryRating(it) }

    fun savePlayerRating(rating: Int) {
        queries.upsertRating("global", rating.toLong())
    }

    fun saveCategoryRating(category: Category, rating: Int) {
        queries.upsertRating(category.name, rating.toLong())
    }

    // Ratings par TAG (ex. « capitale ») : même table KV, clé préfixée `tag_` pour ne pas collisionner
    // avec « global » ni les noms de catégories.
    fun getTagRating(tag: String): Int =
        queries.getRating("tag_$tag").executeAsOneOrNull()?.toInt() ?: 750

    fun getAllTagRatings(): Map<String, Int> =
        TRACKED_TAGS.associateWith { getTagRating(it) }

    fun saveTagRating(tag: String, rating: Int) {
        queries.upsertRating("tag_$tag", rating.toLong())
    }

    /** Efface ratings ELO ET séries (même table `player_ratings`). Pour la réinitialisation locale. */
    fun clear() = queries.deleteAll()
}
