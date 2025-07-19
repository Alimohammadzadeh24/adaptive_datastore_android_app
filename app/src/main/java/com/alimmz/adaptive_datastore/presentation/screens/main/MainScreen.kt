package com.alimmz.adaptive_datastore.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import com.alimmz.adaptive_datastore.presentation.navigation.Screen
import com.alimmz.adaptive_datastore.presentation.screens.main.add_habit.AddHabitScreen
import com.alimmz.adaptive_datastore.presentation.screens.main.home.HomeScreen
import com.alimmz.adaptive_datastore.presentation.ui.components.BottomNavigationBar

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Settings Screen")
    }
}

@Composable
fun HabitDetailsScreen(habitId: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Habit Details Screen for ID: $habitId")
    }
}

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
        Box(
            modifier = Modifier.padding(innerPadding)
        ){
            when(currentScreen){
                Screen.Home -> HomeScreen()
                Screen.AddHabit -> AddHabitScreen()
                Screen.Settings -> SettingsScreen()
                is Screen.HabitDetails -> HabitDetailsScreen(habitId = currentScreen.id)
            }
        }
    }
}