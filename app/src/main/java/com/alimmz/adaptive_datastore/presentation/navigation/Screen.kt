package com.alimmz.adaptive_datastore.presentation.navigation

sealed interface Screen {
    data object Home : Screen
    data class HabitDetails(val id: String) : Screen
    data object AddHabit: Screen
    data object Settings: Screen
}