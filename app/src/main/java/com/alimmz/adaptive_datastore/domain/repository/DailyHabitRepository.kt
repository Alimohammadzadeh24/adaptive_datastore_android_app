package com.alimmz.adaptive_datastore.domain.repository

import com.alimmz.adaptive_datastore.domain.entities.DailyHabit
import com.alimmz.adaptive_datastore.domain.entities.DailyHabitsList
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import kotlinx.coroutines.flow.Flow

interface DailyHabitRepository {
    suspend fun addDailyHabit(habit: DailyHabit) : DataResult<Unit>
    suspend fun getDailyHabits(): DataResult<DailyHabitsList>
    suspend fun updateDailyHabit(habit: DailyHabit) : DataResult<Unit>
    suspend fun deleteDailyHabit(habit: DailyHabit) : DataResult<Unit>
    suspend fun clearDailyHabits() : DataResult<Unit>
    suspend fun toggleHabitDoneStatus(habit: DailyHabit) : DataResult<Unit>
}