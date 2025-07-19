package com.alimmz.adaptive_datastore.presentation.screens.main.add_habit

sealed interface AddHabitUiAction {
    data class UpdateTitle(val title: String) : AddHabitUiAction
    data class UpdateDescription(val description: String) : AddHabitUiAction
    data object SaveHabit : AddHabitUiAction
    data object ClearError : AddHabitUiAction
    data object ClearSuccess : AddHabitUiAction
}