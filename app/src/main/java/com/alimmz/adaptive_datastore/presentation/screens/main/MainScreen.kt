package com.alimmz.adaptive_datastore.presentation.screens.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.alimmz.adaptive_datastore.presentation.navigation.Screen
import com.alimmz.adaptive_datastore.presentation.screens.main.add_habit.AddHabitScreen
import com.alimmz.adaptive_datastore.presentation.screens.main.home.HomeScreen
import com.alimmz.adaptive_datastore.presentation.screens.main.settings.SettingsScreen
import com.alimmz.adaptive_datastore.presentation.ui.components.BottomNavigationBar

@Composable
fun MainScreen(
    onNavigateToOtherScreen: (Screen) -> Unit,
    currentScreen: Screen
){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onClickItem = onNavigateToOtherScreen,
                selectedScreen = currentScreen,
            )
        }
    ) { innerPadding ->
        when(currentScreen){
            Screen.Home -> HomeScreen()
            Screen.AddHabit -> AddHabitScreen()
            Screen.Settings -> SettingsScreen()
            is Screen.HabitDetails -> {

            }
        }
    }
}