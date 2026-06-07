package com.fabien.trivia

import androidx.compose.ui.window.ComposeUIViewController
import com.fabien.trivia.data.DatabaseDriverFactory

fun MainViewController() = ComposeUIViewController { App(DatabaseDriverFactory()) }