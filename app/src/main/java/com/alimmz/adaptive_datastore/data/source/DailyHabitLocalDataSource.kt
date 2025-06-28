package com.alimmz.adaptive_datastore.data.source

import com.alimmz.adaptive_datastore.domain.entities.DailyHabit
import com.alimmz.adaptive_datastore.domain.entities.DailyHabitsList
import kotlinx.coroutines.flow.Flow

interface DailyHabitLocalDataSource {
    suspend fun addDailyHabit(habit: DailyHabit)
    suspend fun getDailyHabits(): Flow<DailyHabitsList>
    suspend fun updateDailyHabit(habit: DailyHabit)
    suspend fun deleteDailyHabit(habit: DailyHabit)
    suspend fun clearDailyHabits()
    suspend fun doneDailyHabit(habit: DailyHabit)
}