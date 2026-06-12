package com.fabien.trivia

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fabien.trivia.data.Category
import com.fabien.trivia.data.DatabaseDriverFactory
import com.fabien.trivia.data.multiplayer.GameStatus
import com.fabien.trivia.ui.account.AccountScreen
import com.fabien.trivia.ui.account.AuthViewModel
import com.fabien.trivia.ui.admin.AdminExportScreen
import com.fabien.trivia.ui.category.CategoryScreen
import com.fabien.trivia.ui.game.GamePhase
import com.fabien.trivia.ui.game.GameScreen
import com.fabien.trivia.ui.game.GameViewModel
import com.fabien.trivia.ui.home.HomeScreen
import com.fabien.trivia.ui.multiplayer.MultiplayerScreen
import com.fabien.trivia.ui.multiplayer.MultiplayerViewModel
import com.fabien.trivia.ui.profile.CategoryHistoryScreen
import com.fabien.trivia.ui.profile.ProfileScreen
import com.fabien.trivia.ui.theme.AppIcons
import com.fabien.trivia.ui.theme.CultureGeneraleTheme

private enum class AppTab { GAME, MULTIPLAYER, PROFILE }

@Composable
fun App(driverFactory: DatabaseDriverFactory) {
    val viewModel = viewModel { GameViewModel(driverFactory) }
    val authViewModel = viewModel { AuthViewModel() }
    val multiplayerViewModel = viewModel { MultiplayerViewModel() }
    var currentTab by remember { mutableStateOf(AppTab.GAME) }
    var showAccount by remember { mutableStateOf(false) }
    var showAdmin by remember { mutableStateOf(false) }
    var historyCategory by remember { mutableStateOf<Category?>(null) }

    CultureGeneraleTheme {
        val state by viewModel.state.collectAsState()
        val authState by authViewModel.state.collectAsState()
        val mpState by multiplayerViewModel.state.collectAsState()

        // Par défaut on a toujours un compte (anonyme) : à froid ou après une déconnexion,
        // on crée/recrée un invité anonyme. L'UI traite `null` comme un invité le temps que
        // ça se fasse (et reste utilisable hors-ligne si la création échoue).
        LaunchedEffect(authState.user == null) {
            if (authState.user == null) authViewModel.continueAsGuest()
        }

        // À chaque changement d'utilisateur connecté, on (re)synchronise le rating avec Firestore.
        LaunchedEffect(authState.user?.uid) {
            viewModel.onUserChanged(authState.user?.uid)
        }

        // H1 — À la connexion COMME à la déconnexion (bascule compte email ↔ invité), revenir à l'Accueil
        // et réinitialiser la vue Profil : sinon l'écran compte/connexion resterait affiché au retour sur
        // l'onglet Profil. (Se déclenche aussi au tout 1er affichage, sans effet visible = valeurs par défaut.)
        LaunchedEffect(authState.isEmailUser) {
            currentTab = AppTab.GAME
            showAccount = false
            showAdmin = false
            historyCategory = null
        }

        // Pré-remplissage du pseudo multijoueur depuis le compte connecté (modifiable ensuite).
        // Repli sur le préfixe de l'email si aucun pseudo n'est encore enregistré.
        LaunchedEffect(authState.isEmailUser, authState.pseudo, authState.user?.email) {
            if (authState.isEmailUser) {
                val prefill = authState.pseudo.ifBlank { authState.user?.email?.substringBefore("@").orEmpty() }
                if (prefill.isNotBlank()) multiplayerViewModel.prefillPseudo(prefill)
            }
        }

        // Une partie multijoueur qui démarre compte aussi pour la série quotidienne.
        LaunchedEffect(mpState.room?.status) {
            if (mpState.room?.status == GameStatus.PLAYING) viewModel.registerPlay()
        }

        // Les réponses du multijoueur alimentent le pool de révision (géré par le GameViewModel,
        // seul détenteur de la base locale) : mauvaise réponse → ajoutée, bonne → retirée.
        LaunchedEffect(Unit) {
            multiplayerViewModel.onAnswerGraded = { questionId, correct ->
                viewModel.recordMultiplayerAnswer(questionId, correct)
            }
        }

        val accountStatus = when {
            authState.user == null -> "Non connecté — appuyez pour vous connecter"
            authState.isGuest -> "Invité — appuyez pour créer un compte"
            else -> authState.user?.email ?: "Connecté"
        }

        // On masque la barre pendant une partie en cours (solo ou multi).
        val inMultiplayerGame = currentTab == AppTab.MULTIPLAYER && mpState.room?.status == GameStatus.PLAYING
        val hideBottomBar = state.phase == GamePhase.PLAYING || inMultiplayerGame

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                if (!hideBottomBar) {
                    NavigationBar {
                        NavigationBarItem(
                            selected = currentTab == AppTab.GAME,
                            onClick = { currentTab = AppTab.GAME },
                            icon = { Icon(AppIcons.Home, contentDescription = null) },
                            label = { Text("Accueil") }
                        )
                        NavigationBarItem(
                            selected = currentTab == AppTab.MULTIPLAYER,
                            onClick = { currentTab = AppTab.MULTIPLAYER },
                            icon = { Icon(AppIcons.Users, contentDescription = null) },
                            label = { Text("Multijoueur") }
                        )
                        NavigationBarItem(
                            selected = currentTab == AppTab.PROFILE,
                            onClick = { currentTab = AppTab.PROFILE },
                            icon = { Icon(AppIcons.Star, contentDescription = null) },
                            label = { Text("Profil") }
                        )
                    }
                }
            }
        ) { innerPadding ->
            when (currentTab) {
                AppTab.MULTIPLAYER -> Box(modifier = Modifier.padding(innerPadding)) {
                    MultiplayerScreen(
                        viewModel = multiplayerViewModel,
                        onExit = { currentTab = AppTab.GAME }
                    )
                }

                AppTab.PROFILE -> if (showAdmin) {
                    AdminExportScreen(
                        modifier = Modifier.padding(innerPadding),
                        onBack = { showAdmin = false },
                    )
                } else if (showAccount) {
                    AccountScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = authState,
                        onSignIn = authViewModel::signIn,
                        onSignUp = { email, password, pseudo ->
                            // Invité anonyme → on convertit le compte (linkEmail garde l'UID et la
                            // progression déjà synchronisée). Sinon création d'un compte neuf.
                            if (authState.isGuest) authViewModel.linkEmail(email, password, pseudo)
                            else authViewModel.register(email, password, pseudo)
                        },
                        onSavePseudo = { pseudo ->
                            authViewModel.setPseudo(pseudo)
                            authViewModel.savePseudo()
                        },
                        onSignOut = {
                            // On réinitialise la progression LOCALE AVANT de se déconnecter : ainsi le
                            // nouvel invité anonyme repart vierge, et on ne pousse pas de défauts vers le
                            // cloud de l'ancien compte (ses données restent dans son doc, restaurées au
                            // prochain login). cf. GameViewModel.resetLocalData.
                            viewModel.resetLocalData()
                            authViewModel.signOut()
                        },
                        onBack = {
                            showAccount = false
                            authViewModel.clearError()
                        },
                        isAdmin = authState.isAdmin,
                        onOpenAdmin = { showAdmin = true },
                    )
                } else if (historyCategory != null) {
                    val category = historyCategory!!
                    val history = remember(category, state.profileStats) { viewModel.loadCategoryHistory(category) }
                    CategoryHistoryScreen(
                        modifier = Modifier.padding(innerPadding),
                        history = history,
                        onBack = { historyCategory = null }
                    )
                } else {
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding),
                        playerRating = state.playerRating,
                        categoryRatings = state.categoryRatings,
                        accountStatus = accountStatus,
                        pseudo = authState.pseudo,
                        isSignedIn = authState.isEmailUser,
                        stats = state.profileStats,
                        onOpenAccount = { showAccount = true },
                        onSelectCategory = { historyCategory = it }
                    )
                }

                AppTab.GAME -> when (state.phase) {
                    GamePhase.HOME -> HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        playerRating = state.playerRating,
                        categoryRatings = state.categoryRatings,
                        streak = state.streak,
                        pseudo = authState.pseudo,
                        reviewCount = state.reviewCount,
                        onStartAllCategories = { viewModel.startGame(null) },
                        onChooseCategory = viewModel::goToCategorySelect,
                        onReview = viewModel::startReview,
                        // H2 — clic « Niveau global » → onglet Profil ; clic « Bonjour … » → écran Compte.
                        onOpenProfile = {
                            currentTab = AppTab.PROFILE
                            showAccount = false
                            showAdmin = false
                            historyCategory = null
                        },
                        onOpenAccount = {
                            currentTab = AppTab.PROFILE
                            showAccount = true
                        }
                    )
                    GamePhase.CATEGORY_SELECT -> CategoryScreen(
                        modifier = Modifier.padding(innerPadding),
                        categoryRatings = state.categoryRatings,
                        onSelectCategory = { viewModel.startGame(it) },
                        onGoBack = viewModel::goHome
                    )
                    GamePhase.PLAYING -> GameScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = state,
                        onSelectAnswer = viewModel::selectAnswer,
                        onNextQuestion = viewModel::nextQuestion,
                        onGoHome = viewModel::goHome
                    )
                }
            }
        }
    }
}
