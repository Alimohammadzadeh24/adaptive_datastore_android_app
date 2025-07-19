package com.alimmz.adaptive_datastore.presentation.screens.main.home

import com.alimmz.adaptive_datastore.domain.entities.DailyHabit

sealed interface HomeUiAction {
    data object GetDailyHabitsList : HomeUiAction
    data class ToggleHabitDoneStatus(val habit: DailyHabit) : HomeUiAction
    data class DeleteHabit(val habit: DailyHabit) : HomeUiAction
}