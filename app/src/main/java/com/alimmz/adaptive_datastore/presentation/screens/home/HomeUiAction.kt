package com.alimmz.adaptive_datastore.presentation.screens.home

sealed interface HomeUiAction {
    data object GetDailyHabitsList : HomeUiAction
}