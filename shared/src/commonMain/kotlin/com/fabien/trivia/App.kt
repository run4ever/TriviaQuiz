package com.fabien.trivia

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fabien.trivia.data.DatabaseDriverFactory
import com.fabien.trivia.ui.category.CategoryScreen
import com.fabien.trivia.ui.game.GamePhase
import com.fabien.trivia.ui.game.GameScreen
import com.fabien.trivia.ui.game.GameViewModel
import com.fabien.trivia.ui.home.HomeScreen
import com.fabien.trivia.ui.theme.CultureGeneraleTheme

@Composable
fun App(driverFactory: DatabaseDriverFactory) {
    val viewModel = viewModel { GameViewModel(driverFactory) }
    CultureGeneraleTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val state by viewModel.state.collectAsState()
            when (state.phase) {
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
