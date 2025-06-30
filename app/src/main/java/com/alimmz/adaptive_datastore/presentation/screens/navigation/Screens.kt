package com.alimmz.adaptive_datastore.presentation.screens.navigation

sealed interface Screens {
    data object Home : Screens
    data class HabitDetails(val id: String) : Screens
    data object AddHabit: Screens
}