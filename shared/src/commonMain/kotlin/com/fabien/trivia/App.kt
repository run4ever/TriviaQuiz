package com.fabien.trivia

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fabien.trivia.data.DatabaseDriverFactory
import com.fabien.trivia.ui.account.AccountScreen
import com.fabien.trivia.ui.account.AuthViewModel
import com.fabien.trivia.ui.category.CategoryScreen
import com.fabien.trivia.ui.game.GamePhase
import com.fabien.trivia.ui.game.GameScreen
import com.fabien.trivia.ui.game.GameViewModel
import com.fabien.trivia.ui.home.HomeScreen
import com.fabien.trivia.ui.profile.ProfileScreen
import com.fabien.trivia.ui.theme.CultureGeneraleTheme

private enum class AppTab { GAME, PROFILE }

@Composable
fun App(driverFactory: DatabaseDriverFactory) {
    val viewModel = viewModel { GameViewModel(driverFactory) }
    val authViewModel = viewModel { AuthViewModel() }
    var currentTab by remember { mutableStateOf(AppTab.GAME) }
    var showAccount by remember { mutableStateOf(false) }

    CultureGeneraleTheme {
        val state by viewModel.state.collectAsState()
        val authState by authViewModel.state.collectAsState()

        val accountStatus = when {
            authState.user == null -> "Non connecté — appuyez pour vous connecter"
            authState.isGuest -> "Invité — appuyez pour créer un compte"
            else -> authState.user?.email ?: "Connecté"
        }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                if (state.phase != GamePhase.PLAYING) {
                    NavigationBar {
                        NavigationBarItem(
                            selected = currentTab == AppTab.GAME,
                            onClick = { currentTab = AppTab.GAME },
                            icon = { Icon(Icons.Default.Home, contentDescription = null) },
                            label = { Text("Jouer") }
                        )
                        NavigationBarItem(
                            selected = currentTab == AppTab.PROFILE,
                            onClick = { currentTab = AppTab.PROFILE },
                            icon = { Icon(Icons.Default.Person, contentDescription = null) },
                            label = { Text("Profil") }
                        )
                    }
                }
            }
        ) { innerPadding ->
            when {
                currentTab == AppTab.PROFILE -> if (showAccount) {
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
                        }
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
                else -> when (state.phase) {
                    GamePhase.HOME -> HomeScreen(
                        modifier = Modifier.padding(innerPadding),
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
