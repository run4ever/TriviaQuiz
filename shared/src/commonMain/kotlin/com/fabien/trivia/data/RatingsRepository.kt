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

    /** Efface ratings ELO ET séries (même table `player_ratings`). Pour la réinitialisation locale. */
    fun clear() = queries.deleteAll()
}
