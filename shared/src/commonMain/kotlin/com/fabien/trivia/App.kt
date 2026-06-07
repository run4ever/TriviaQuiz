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
    var currentTab by remember { mutableStateOf(AppTab.GAME) }

    CultureGeneraleTheme {
        val state by viewModel.state.collectAsState()
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
                currentTab == AppTab.PROFILE -> ProfileScreen(
                    modifier = Modifier.padding(innerPadding),
                    playerRating = state.playerRating,
                    categoryRatings = state.categoryRatings
                )
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
