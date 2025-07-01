package com.alimmz.adaptive_datastore.presentation.screens.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.alimmz.adaptive_datastore.presentation.screens.home.HomeScreen

@Composable
fun DailyHabitNav(){

    val backStack = remember { mutableStateListOf<Screens>(Screens.Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Screens.Home -> NavEntry(key) {
                    HomeScreen {  }
                }

                Screens.AddHabit -> NavEntry(key) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Add Habit Screen")
                    }
                }

                is Screens.HabitDetails -> NavEntry(key) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Habit Details Screen")
                    }
                }

            }
        }
    )
}