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
import com.fabien.trivia.data.DatabaseDriverFactory
import com.fabien.trivia.data.multiplayer.GameStatus
import com.fabien.trivia.ui.account.AccountScreen
import com.fabien.trivia.ui.account.AuthViewModel
import com.fabien.trivia.ui.category.CategoryScreen
import com.fabien.trivia.ui.game.GamePhase
import com.fabien.trivia.ui.game.GameScreen
import com.fabien.trivia.ui.game.GameViewModel
import com.fabien.trivia.ui.home.HomeScreen
import com.fabien.trivia.ui.multiplayer.MultiplayerScreen
import com.fabien.trivia.ui.multiplayer.MultiplayerViewModel
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

    CultureGeneraleTheme {
        val state by viewModel.state.collectAsState()
        val authState by authViewModel.state.collectAsState()
        val mpState by multiplayerViewModel.state.collectAsState()

        // À chaque changement d'utilisateur connecté, on (re)synchronise le rating avec Firestore.
        LaunchedEffect(authState.user?.uid) {
            viewModel.onUserChanged(authState.user?.uid)
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

                AppTab.PROFILE -> if (showAccount) {
                    AccountScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = authState,
                        onSignIn = authViewModel::signIn,
                        onRegister = authViewModel::register,
                        onContinueAsGuest = authViewModel::continueAsGuest,
                        onLinkEmail = authViewModel::linkEmail,
                        onSignOut = authViewModel::signOut,
                        onBack = {
                            showAccount = false
                            authViewModel.clearError()
                        },
                        onPseudoChange = authViewModel::setPseudo,
                        onSavePseudo = authViewModel::savePseudo
                    )
                } else {
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding),
                        playerRating = state.playerRating,
                        categoryRatings = state.categoryRatings,
                        accountStatus = accountStatus,
                        onOpenAccount = { showAccount = true }
                    )
                }

                AppTab.GAME -> when (state.phase) {
                    GamePhase.HOME -> HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        playerRating = state.playerRating,
                        categoryRatings = state.categoryRatings,
                        onStartAllCategories = { viewModel.startGame(null) },
                        onChooseCategory = viewModel::goToCategorySelect
                    )
                    GamePhase.CATEGORY_SELECT -> CategoryScreen(
                        modifier = Modifier.padding(innerPadding),
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
