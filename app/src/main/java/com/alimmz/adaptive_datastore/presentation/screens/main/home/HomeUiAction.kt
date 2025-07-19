package com.alimmz.adaptive_datastore.presentation.screens.main.home

sealed interface HomeUiAction {
    data object GetDailyHabitsList : HomeUiAction
}