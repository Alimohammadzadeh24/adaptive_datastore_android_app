package com.alimmz.adaptive_datastore.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.alimmz.adaptive_datastore.presentation.screens.main.MainScreen

@Composable
fun DailyHabitNav() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    MainScreen(
        onNavigateToOtherScreen = { screen ->
            currentScreen = screen
        },
        currentScreen = currentScreen
    )
}