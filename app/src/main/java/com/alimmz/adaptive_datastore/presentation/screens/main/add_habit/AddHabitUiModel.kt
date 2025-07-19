package com.alimmz.adaptive_datastore.presentation.screens.main.add_habit

data class AddHabitUiModel(
    val title: String = "",
    val description: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String = ""
)