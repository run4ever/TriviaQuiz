package com.fabien.trivia.data

class RatingsRepository(driverFactory: DatabaseDriverFactory) {
    private val queries: RatingsQueries

    init {
        val driver = driverFactory.createDriver()
        queries = TriviaDatabase(driver).ratingsQueries
    }

    fun getPlayerRating(): Int =
        queries.getRating("global").executeAsOneOrNull()?.toInt() ?: 1000

    fun getCategoryRating(category: Category): Int =
        queries.getRating(category.name).executeAsOneOrNull()?.toInt() ?: 1000

    fun getAllCategoryRatings(): Map<Category, Int> =
        Category.entries.associateWith { getCategoryRating(it) }

    fun savePlayerRating(rating: Int) {
        queries.upsertRating("global", rating.toLong())
    }

    fun saveCategoryRating(category: Category, rating: Int) {
        queries.upsertRating(category.name, rating.toLong())
    }
}
