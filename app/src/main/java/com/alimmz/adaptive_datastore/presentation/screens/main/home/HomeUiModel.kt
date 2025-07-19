package com.alimmz.adaptive_datastore.presentation.screens.main.home

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.alimmz.adaptive_datastore.domain.entities.DailyHabit

data class HomeUiModel(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val dailyHabits: SnapshotStateList<DailyHabit> = SnapshotStateList(),
)