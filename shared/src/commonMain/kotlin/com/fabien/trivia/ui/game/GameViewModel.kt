package com.fabien.trivia.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.DatabaseDriverFactory
import com.fabien.trivia.data.PlayerRatingSync
import com.fabien.trivia.data.PlayerRatings
import com.fabien.trivia.data.PlayerSync
import com.fabien.trivia.data.Question
import com.fabien.trivia.data.QuestionRepository
import com.fabien.trivia.data.QuestionStatsRepository
import com.fabien.trivia.data.QuestionStatsSync
import com.fabien.trivia.data.RatingsRepository
import com.fabien.trivia.data.RemoteQuestionRepository
import com.fabien.trivia.data.QuestionHistoryRepository
import com.fabien.trivia.data.QuestionHistorySync
import com.fabien.trivia.data.ReviewPoolRepository
import com.fabien.trivia.data.ReviewPoolSync
import com.fabien.trivia.data.mergeQuestionHistory
import com.fabien.trivia.data.mergeReviewPool
import com.fabien.trivia.data.StreakRepository
import com.fabien.trivia.data.StreakSync
import com.fabien.trivia.data.TriviaDatabase
import com.fabien.trivia.data.mergeStreaks
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlin.math.pow
import kotlin.math.roundToInt

enum class GamePhase { HOME, CATEGORY_SELECT, PLAYING }

/**
 * Données affichées sur l'écran Profil : meilleures séries (records) + leur date, et l'activité
 * (questions posées + bonnes réponses), global et par catégorie.
 * ⚠️ « posées » = `times_seen` → une question vue N fois compte N (répétitions incluses). Le mode
 * révision étant neutre, il n'incrémente pas ces compteurs.
 */
data class ProfileStats(
    val globalBest: Int = 0,
    val globalBestDate: LocalDate? = null,
    val categoryBest: Map<Category, Int> = emptyMap(),
    val categoryBestDate: Map<Category, LocalDate?> = emptyMap(),
    val globalAsked: Int = 0,
    val globalCorrect: Int = 0,
    val categoryAsked: Map<Category, Int> = emptyMap(),
    val categoryCorrect: Map<Category, Int> = emptyMap(),
)

/** Un passage récent dans l'historique d'une catégorie : la question, sa date et sa justesse. */
data class RecentAttempt(val question: Question, val date: LocalDate, val correct: Boolean)

/** Données de l'écran « historique par catégorie » : la liste plate des passages récents (≤ 100). */
data class CategoryHistory(
    val category: Category,
    val attempts: List<RecentAttempt>,
)

data class GameState(
    val phase: GamePhase = GamePhase.HOME,
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedAnswerIndex: Int? = null,
    val answerConfirmed: Boolean = false,
    val playerRating: Int = 750,
    val categoryRatings: Map<Category, Int> = Category.entries.associateWith { 750 },
    val lastRatingDelta: Int = 0,
    val selectedCategory: Category? = null,
    /** Session de révision en cours (questions ratées rejouées). Mode neutre : n'affecte ni ELO, ni séries, ni anti-grind. */
    val isReview: Boolean = false,
    /** Nombre de questions actuellement dans le pool de révision (pour le bouton de l'accueil). */
    val reviewCount: Int = 0,
    val streak: Int = 0,
    /** Bonnes réponses consécutives (solo), PERSISTÉE : continue d'un jour/session à l'autre, remise à 0 sur erreur. ≠ série de jours [streak]. */
    val correctStreak: Int = 0,
    /** Meilleure suite de bonnes réponses (record persistant, pour le futur écran de stats). */
    val bestCorrectStreak: Int = 0,
    /** Stats du profil (records de série + dates), global + par catégorie. */
    val profileStats: ProfileStats = ProfileStats()
) {
    val displayedRating: Int
        get() = if (selectedCategory != null) categoryRatings[selectedCategory] ?: 750 else playerRating
}

class GameViewModel(driverFactory: DatabaseDriverFactory) : ViewModel() {
    private val database = TriviaDatabase(driverFactory.createDriver())
    private val ratingsRepository = RatingsRepository(database)
    private val questionStatsRepository = QuestionStatsRepository(database)
    private val streakRepository = StreakRepository(database)
    private val reviewPoolRepository = ReviewPoolRepository(database)
    private val questionHistoryRepository = QuestionHistoryRepository(database)
    private val ratingSync = PlayerRatingSync()
    private val streakSync = StreakSync()
    private val reviewPoolSync = ReviewPoolSync()
    private val questionStatsSync = QuestionStatsSync()
    private val questionHistorySync = QuestionHistorySync()
    // Push GROUPÉ (1 écriture/réponse) ; les *Sync individuels ne servent plus qu'à la réconciliation au login.
    private val playerSync = PlayerSync()
    private val remoteQuestions = RemoteQuestionRepository()

    /**
     * Banque de questions effective. Démarre sur le set bundlé (disponible instantanément,
     * offline-first) puis est remplacée par les questions distantes dès qu'elles sont récupérées.
     * Déclarée AVANT [_state] car [readProfileStats] (appelée à la création de l'état) en a besoin
     * pour résoudre la catégorie de chaque question.
     */
    private var questionPool: List<Question> = QuestionRepository.questions

    private val _state = MutableStateFlow(GameState(
        playerRating = ratingsRepository.getPlayerRating(),
        categoryRatings = ratingsRepository.getAllCategoryRatings(),
        streak = streakRepository.currentStreak(),
        correctStreak = streakRepository.correctStreak(null),
        bestCorrectStreak = streakRepository.bestCorrectStreak(null),
        profileStats = readProfileStats(),
        reviewCount = reviewPoolRepository.count()
    ))

    private fun readProfileStats(): ProfileStats {
        // Activité par catégorie depuis les COMPTEURS d'affichage de question_stats (seen_all / correct_all,
        // solo + multi). Bornés au nombre de questions vues, et synchronisés par compte. La catégorie n'y
        // est pas stockée → résolue via la banque (question_id → Category).
        val categoryById = questionPool.associate { it.id to it.category }
        val asked = HashMap<Category, Int>()
        val correct = HashMap<Category, Int>()
        questionStatsRepository.totals().forEach { row ->
            val category = categoryById[row.questionId] ?: return@forEach
            asked[category] = (asked[category] ?: 0) + row.seenAll
            correct[category] = (correct[category] ?: 0) + row.correctAll
        }
        return ProfileStats(
            globalBest = streakRepository.bestCorrectStreak(null),
            globalBestDate = streakRepository.bestStreakDate(null),
            categoryBest = Category.entries.associateWith { streakRepository.bestCorrectStreak(it) },
            categoryBestDate = Category.entries.associateWith { streakRepository.bestStreakDate(it) },
            categoryAsked = Category.entries.associateWith { asked[it] ?: 0 },
            categoryCorrect = Category.entries.associateWith { correct[it] ?: 0 },
            globalAsked = asked.values.sum(),
            globalCorrect = correct.values.sum(),
        )
    }
    val state: StateFlow<GameState> = _state.asStateFlow()

    /** UID du compte connecté, null si déconnecté. Détermine si on pousse vers Firestore. */
    private var currentUid: String? = null

    init {
        refreshQuestions()
    }

    /** Récupère les questions distantes ; en cas d'échec (hors-ligne), on garde le set bundlé. */
    private fun refreshQuestions() {
        viewModelScope.launch {
            try {
                val remote = remoteQuestions.fetchAll()
                if (remote.isNotEmpty()) questionPool = remote
            } catch (_: Exception) {
                // Hors-ligne / collection absente : fallback sur le set bundlé déjà en place.
            }
        }
    }

    private fun questionsFor(category: Category?): List<Question> =
        if (category != null) questionPool.filter { it.category == category } else questionPool

    /**
     * Appelé quand l'utilisateur connecté change (connexion / déconnexion / changement de compte).
     * - connexion avec un doc cloud existant → le cloud fait foi : on écrase le rating local.
     * - connexion sans doc cloud → on sème le cloud depuis le local.
     * - déconnexion (uid null) → on garde le local tel quel, plus de push.
     * Toute erreur réseau est ignorée : le local reste autoritaire et Firestore resynchronisera.
     */
    fun onUserChanged(uid: String?) {
        currentUid = uid
        if (uid == null) return
        viewModelScope.launch {
            try {
                val cloud = ratingSync.fetch(uid)
                if (cloud != null) {
                    applyCloudRatings(cloud)
                } else {
                    ratingSync.push(uid, currentLocalRatings())
                }
            } catch (_: Exception) {
                // Hors-ligne / erreur : le local reste source de vérité ; la synchro reprendra plus tard.
            }
            try {
                syncStreaks(uid)
            } catch (_: Exception) {
                // Idem : les séries restent locales, la synchro reprendra à la prochaine connexion.
            }
            try {
                syncReviewPool(uid)
            } catch (_: Exception) {
                // Idem : le pool de révision reste local, la synchro reprendra à la prochaine connexion.
            }
            try {
                syncQuestionStats(uid)
            } catch (_: Exception) {
                // Idem : les stats par question restent locales, la synchro reprendra plus tard.
            }
            try {
                syncQuestionHistory(uid)
            } catch (_: Exception) {
                // Idem : l'historique reste local, la synchro reprendra plus tard.
            }
        }
    }

    /**
     * Stats par question à la connexion : stratégie « cloud autoritaire » (comme les ratings) pour éviter
     * le double-comptage d'une fusion additive. Si un doc cloud existe → on écrase le local ; sinon on
     * sème le cloud depuis le local. Puis on rafraîchit les compteurs du Profil.
     */
    private suspend fun syncQuestionStats(uid: String) {
        val cloud = questionStatsSync.fetch(uid)
        if (cloud != null) {
            questionStatsRepository.write(cloud)
        } else {
            questionStatsSync.push(uid, questionStatsRepository.snapshot())
        }
        _state.value = _state.value.copy(profileStats = readProfileStats())
    }

    /** Historique à la connexion : union local ↔ cloud puis re-plafond à 100/cat (cf. [mergeQuestionHistory]). */
    private suspend fun syncQuestionHistory(uid: String) {
        val local = questionHistoryRepository.snapshot()
        val cloud = questionHistorySync.fetch(uid)
        val merged = if (cloud == null) local else mergeQuestionHistory(local, cloud)
        questionHistoryRepository.write(merged)
        questionHistorySync.push(uid, merged)
    }

    /**
     * Push GROUPÉ : pousse TOUT l'état synchronisable du joueur en UNE écriture `merge` sur `players/{uid}`
     * (ratings + séries + pool de révision + stats + historique), au lieu de 5 écritures séparées.
     * Fire-and-forget, ne touche pas au pseudo (merge). À appeler après toute évolution de l'état en jeu.
     */
    private fun pushAll() {
        val uid = currentUid ?: return
        viewModelScope.launch {
            try {
                playerSync.pushAll(
                    uid,
                    currentLocalRatings(),
                    streakRepository.snapshot(),
                    reviewPoolRepository.snapshot(),
                    questionStatsRepository.snapshot(),
                    questionHistoryRepository.snapshot(),
                )
            } catch (_: Exception) {
                // Firestore rejoue l'écriture à la reconnexion.
            }
        }
    }

    /**
     * Réinitialise toute la progression LOCALE (à appeler à la déconnexion explicite, AVANT le signOut).
     * ⚠️ On met d'abord `currentUid = null` pour COUPER toute synchro : sinon on pousserait les valeurs par
     * défaut vers le cloud de l'ancien compte email et on EFFACERAIT ses données. Les données du compte
     * restent intactes dans son doc Firestore et seront restaurées à la prochaine connexion. Le nouvel
     * invité anonyme (créé juste après) sèmera son propre cloud avec ces défauts.
     */
    fun resetLocalData() {
        currentUid = null
        ratingsRepository.clear()            // ratings ELO + séries (même table)
        questionStatsRepository.deleteAll()
        questionHistoryRepository.deleteAll()
        reviewPoolRepository.clear()
        _state.value = GameState(
            playerRating = ratingsRepository.getPlayerRating(),
            categoryRatings = ratingsRepository.getAllCategoryRatings(),
            streak = streakRepository.currentStreak(),
            correctStreak = streakRepository.correctStreak(null),
            bestCorrectStreak = streakRepository.bestCorrectStreak(null),
            profileStats = readProfileStats(),
            reviewCount = reviewPoolRepository.count(),
        )
    }

    /**
     * Fusionne le pool de révision local ↔ cloud à la connexion (union par id, cf. [mergeReviewPool]) :
     * on écrit le résultat en local ET on le repousse, puis on rafraîchit le compteur affiché.
     */
    private suspend fun syncReviewPool(uid: String) {
        val local = reviewPoolRepository.snapshot()
        val cloud = reviewPoolSync.fetch(uid)
        val merged = if (cloud == null) local else mergeReviewPool(local, cloud)
        reviewPoolRepository.write(merged)
        reviewPoolSync.push(uid, merged)
        _state.value = _state.value.copy(reviewCount = reviewPoolRepository.count())
    }

    /**
     * Fusionne séries locales ↔ cloud à la connexion (cf. [mergeStreaks]) : on écrit le résultat en
     * local ET on le repousse, puis on rafraîchit l'état affiché (Accueil / en-tête / Profil).
     */
    private suspend fun syncStreaks(uid: String) {
        val local = streakRepository.snapshot()
        val cloud = streakSync.fetch(uid)
        val merged = if (cloud == null) local else mergeStreaks(local, cloud)
        streakRepository.write(merged)
        streakSync.push(uid, merged)
        refreshStreakState()
    }

    /** Recharge depuis le local les séries affichées (contextuelles : catégorie en cours ou globale). */
    private fun refreshStreakState() {
        val category = _state.value.selectedCategory
        _state.value = _state.value.copy(
            streak = streakRepository.currentStreak(),
            correctStreak = streakRepository.correctStreak(category),
            bestCorrectStreak = streakRepository.bestCorrectStreak(category),
            profileStats = readProfileStats(),
        )
    }

    private fun currentLocalRatings() = PlayerRatings(
        global = _state.value.playerRating,
        categories = _state.value.categoryRatings
    )

    private fun applyCloudRatings(cloud: PlayerRatings) {
        ratingsRepository.savePlayerRating(cloud.global)
        cloud.categories.forEach { (category, rating) -> ratingsRepository.saveCategoryRating(category, rating) }
        _state.value = _state.value.copy(
            playerRating = cloud.global,
            categoryRatings = cloud.categories
        )
    }

    fun goToCategorySelect() {
        _state.value = _state.value.copy(phase = GamePhase.CATEGORY_SELECT)
    }

    fun startGame(category: Category? = null) {
        val questions = questionsFor(category).shuffled()
        // Jouer aujourd'hui (re)alimente la série quotidienne.
        val streak = streakRepository.registerPlay()
        pushAll()
        _state.value = GameState(
            phase = GamePhase.PLAYING,
            questions = questions,
            selectedCategory = category,
            playerRating = _state.value.playerRating,
            categoryRatings = _state.value.categoryRatings,
            streak = streak,
            // Suite de bonnes réponses CONTEXTUELLE (catégorie choisie, ou globale en « toutes catégories »),
            // persistée (ne repart pas à 0 à chaque partie).
            correctStreak = streakRepository.correctStreak(category),
            bestCorrectStreak = streakRepository.bestCorrectStreak(category),
            profileStats = _state.value.profileStats,
            reviewCount = reviewPoolRepository.count()
        )
    }

    /**
     * Démarre une session de révision : les questions actuellement ratées (pool), dans leur ordre
     * d'arrivée (pas de mélange). Mode NEUTRE — les réponses n'affectent ni l'ELO, ni les séries, ni
     * l'anti-grind ; une bonne réponse retire la question du pool, une mauvaise l'y conserve.
     * Les questions absentes de la banque courante (retirées de Firestore) sont ignorées.
     */
    fun startReview() {
        val byId = questionPool.associateBy { it.id }
        val questions = reviewPoolRepository.questionIds().mapNotNull { byId[it] }
        if (questions.isEmpty()) return
        _state.value = _state.value.copy(
            phase = GamePhase.PLAYING,
            isReview = true,
            questions = questions,
            currentIndex = 0,
            selectedAnswerIndex = null,
            answerConfirmed = false,
            lastRatingDelta = 0,
            selectedCategory = null,
            reviewCount = reviewPoolRepository.count()
        )
    }

    /**
     * Réponse multijoueur : met à jour le pool de révision (bonne → retirée, mauvaise → ajoutée) ET
     * enregistre le passage dans l'historique. N'affecte pas l'ELO ni les séries (le multi gère son score).
     */
    fun recordMultiplayerAnswer(questionId: String, correct: Boolean) {
        reviewPoolRepository.record(questionId, correct)
        // Historique + compteurs d'affichage (solo + multi). On NE touche PAS aux compteurs anti-grind
        // solo (recordDisplayCount n'incrémente que seen_all / correct_all) pour ne pas fausser l'ELO.
        val category = questionPool.firstOrNull { it.id == questionId }?.category
        if (category != null) {
            questionHistoryRepository.record(questionId, category.name, correct)
            questionStatsRepository.recordDisplayCount(questionId, correct)
        }
        pushAll()
        _state.value = _state.value.copy(
            reviewCount = reviewPoolRepository.count(),
            profileStats = readProfileStats(),
        )
    }

    /**
     * Charge l'historique d'une catégorie pour l'écran dédié : la liste plate des passages récents
     * (au plus 100, du plus récent au plus ancien), chaque passage = question + date + ✓/✗.
     */
    fun loadCategoryHistory(category: Category): CategoryHistory {
        val byId = questionPool.associateBy { it.id }
        val attempts = questionHistoryRepository.recentForCategory(category.name).mapNotNull { a ->
            val question = byId[a.questionId] ?: return@mapNotNull null
            RecentAttempt(question, a.date, a.correct)
        }
        return CategoryHistory(category = category, attempts = attempts)
    }

    /**
     * Enregistre une partie jouée aujourd'hui pour la série (idempotent dans la journée).
     * Appelé aussi au démarrage d'une partie multijoueur (cf. `App.kt`), pas seulement en solo.
     */
    fun registerPlay() {
        _state.value = _state.value.copy(streak = streakRepository.registerPlay())
        pushAll()
    }

    fun selectAnswer(index: Int) {
        val current = _state.value
        if (current.answerConfirmed) return
        val question = current.questions[current.currentIndex]
        val isCorrect = question.correctIndex == index

        // Mode révision : NEUTRE (n'affecte ni ELO, ni séries, ni anti-grind). On met seulement à jour le
        // pool — bonne réponse → question retirée, mauvaise → conservée — et on affiche le feedback.
        if (current.isReview) {
            reviewPoolRepository.record(question.id, isCorrect)
            pushAll()
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                lastRatingDelta = 0,
                reviewCount = reviewPoolRepository.count()
            )
            return
        }

        // Pool de révision (solo) : bonne réponse → question retirée, mauvaise → ajoutée.
        reviewPoolRepository.record(question.id, isCorrect)
        val reviewCount = reviewPoolRepository.count()
        // Historique (solo) : on trace le passage (date + justesse + catégorie) pour l'écran historique.
        questionHistoryRepository.record(question.id, question.category.name, isCorrect)

        // État persisté de la question : rating dynamique (graine du code si jamais jouée) + historique anti-grind.
        val stats = questionStatsRepository.getStats(question.id)
        val questionRating = stats?.rating?.toInt() ?: question.rating
        val priorCorrect = stats?.timesCorrect?.toInt() ?: 0

        // Anti-grind : le gain est réduit si la question a déjà été réussie auparavant.
        // La pénalité (mauvaise réponse) reste pleine à chaque fois.
        val gainFactor = if (isCorrect) repeatedCorrectFactor(priorCorrect) else 1.0

        val categoryRating = current.categoryRatings[question.category] ?: 750
        val categoryDelta = scaleGain(eloRatingDelta(categoryRating, questionRating, isCorrect), gainFactor)
        val newCategoryRating = (categoryRating + categoryDelta).coerceAtLeast(100)
        val newCategoryRatings = current.categoryRatings + (question.category to newCategoryRating)

        // Suite de bonnes réponses (persistée, miroir des ratings) : on met à jour la suite de la
        // catégorie de la question, et la globale uniquement en mode « toutes catégories ».
        val allCategories = current.selectedCategory == null
        streakRepository.recordAnswer(question.category, isCorrect, includeGlobal = allCategories)
        // Suite contextuelle affichée dans l'en-tête : catégorie en mode catégorie, sinon globale.
        val newCorrectStreak = streakRepository.correctStreak(current.selectedCategory)
        val newBestCorrectStreak = streakRepository.bestCorrectStreak(current.selectedCategory)

        if (current.selectedCategory != null) {
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                categoryRatings = newCategoryRatings,
                lastRatingDelta = categoryDelta,
                correctStreak = newCorrectStreak,
                bestCorrectStreak = newBestCorrectStreak,
                profileStats = readProfileStats(),
                reviewCount = reviewCount
            )
            ratingsRepository.saveCategoryRating(question.category, newCategoryRating)
        } else {
            val globalDelta = scaleGain(eloRatingDelta(current.playerRating, questionRating, isCorrect), gainFactor)
            val newPlayerRating = (current.playerRating + globalDelta).coerceAtLeast(100)
            _state.value = current.copy(
                selectedAnswerIndex = index,
                answerConfirmed = true,
                playerRating = newPlayerRating,
                categoryRatings = newCategoryRatings,
                lastRatingDelta = globalDelta,
                correctStreak = newCorrectStreak,
                bestCorrectStreak = newBestCorrectStreak,
                profileStats = readProfileStats(),
                reviewCount = reviewCount
            )
            ratingsRepository.savePlayerRating(newPlayerRating)
            ratingsRepository.saveCategoryRating(question.category, newCategoryRating)
        }

        // Rating dynamique : la question évolue à l'inverse de l'échange ELO avec le rating de catégorie
        // du joueur (le joueur gagne X → la question perd X). On enregistre aussi la réponse (anti-grind).
        val newQuestionRating = (questionRating - categoryDelta).coerceAtLeast(100)
        val newTimesSeen = (stats?.timesSeen ?: 0L) + 1L
        val newTimesCorrect = (stats?.timesCorrect ?: 0L) + if (isCorrect) 1L else 0L
        // Compteurs d'affichage (solo + multi) : le solo incrémente aussi seen_all / correct_all.
        val newSeenAll = (stats?.seenAll ?: 0L) + 1L
        val newCorrectAll = (stats?.correctAll ?: 0L) + if (isCorrect) 1L else 0L
        questionStatsRepository.save(question.id, newTimesSeen, newTimesCorrect, newQuestionRating, newSeenAll, newCorrectAll)

        // Rating, séries, pool, stats et historique viennent d'évoluer → un seul push groupé (si connecté).
        pushAll()
    }

    fun nextQuestion() {
        val current = _state.value
        // Révision : on parcourt une seule fois le pool figé au démarrage, dans l'ordre. À la fin,
        // retour à l'accueil (les bonnes réponses ont déjà été retirées du pool, les mauvaises conservées).
        if (current.isReview) {
            val nextReviewIndex = current.currentIndex + 1
            if (nextReviewIndex >= current.questions.size) {
                goHome()
            } else {
                _state.value = current.copy(
                    currentIndex = nextReviewIndex,
                    selectedAnswerIndex = null,
                    answerConfirmed = false,
                    lastRatingDelta = 0
                )
            }
            return
        }
        val nextIndex = current.currentIndex + 1
        val (newIndex, newQuestions) = if (nextIndex >= current.questions.size) {
            0 to questionsFor(current.selectedCategory).shuffled()
        } else {
            nextIndex to current.questions
        }
        _state.value = current.copy(
            currentIndex = newIndex,
            questions = newQuestions,
            selectedAnswerIndex = null,
            answerConfirmed = false,
            lastRatingDelta = 0
        )
    }

    fun goHome() {
        _state.value = GameState(
            playerRating = _state.value.playerRating,
            categoryRatings = _state.value.categoryRatings,
            streak = _state.value.streak,
            correctStreak = streakRepository.correctStreak(null),
            bestCorrectStreak = streakRepository.bestCorrectStreak(null),
            profileStats = _state.value.profileStats,
            reviewCount = reviewPoolRepository.count()
        )
    }

    private fun eloRatingDelta(playerRating: Int, questionRating: Int, correct: Boolean): Int {
        val expected = 1.0 / (1.0 + 10.0.pow((questionRating - playerRating) / 400.0))
        val result = if (correct) 1.0 else 0.0
        return (32.0 * (result - expected)).roundToInt()
    }

    /**
     * Facteur appliqué au gain selon le nombre de bonnes réponses déjà données à la question :
     * ×1 la 1re fois, ×0.5 la 2e, ×0 ensuite. Empêche de regagner indéfiniment du rating
     * sur des questions déjà maîtrisées.
     */
    private fun repeatedCorrectFactor(priorCorrect: Int): Double = when (priorCorrect) {
        0 -> 1.0
        1 -> 0.5
        else -> 0.0
    }

    private fun scaleGain(delta: Int, factor: Double): Int =
        if (factor >= 1.0) delta else (delta * factor).roundToInt()
}
