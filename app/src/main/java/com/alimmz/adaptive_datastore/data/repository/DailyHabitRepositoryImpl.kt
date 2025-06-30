package com.alimmz.adaptive_datastore.data.repository

import com.alimmz.adaptive_datastore.data.core.safeCall
import com.alimmz.adaptive_datastore.data.source.DailyHabitLocalDataSource
import com.alimmz.adaptive_datastore.domain.entities.DailyHabit
import com.alimmz.adaptive_datastore.domain.entities.DailyHabitsList
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.repository.DailyHabitRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DailyHabitRepositoryImpl @Inject constructor(
    private val dataSource: DailyHabitLocalDataSource,
) : DailyHabitRepository {
    override suspend fun addDailyHabit(habit: DailyHabit): DataResult<Unit> {
        return safeCall {
            dataSource.addDailyHabit(habit)
        }
    }

    override suspend fun getDailyHabits(): DataResult<DailyHabitsList> {
        return safeCall {
            dataSource.getDailyHabits().first()
        }
    }

    override suspend fun updateDailyHabit(habit: DailyHabit): DataResult<Unit> {
        return safeCall {
            dataSource.updateDailyHabit(habit = habit)
        }
    }

    override suspend fun deleteDailyHabit(habit: DailyHabit): DataResult<Unit> {
        return safeCall {
            dataSource.deleteDailyHabit(habit = habit)
        }
    }

    override suspend fun clearDailyHabits(): DataResult<Unit> {
        return safeCall {
            dataSource.clearDailyHabits()
        }
    }

    override suspend fun toggleHabitDoneStatus(habit: DailyHabit): DataResult<Unit> = safeCall {
        dataSource.toggleHabitDoneStatus(habit = habit)
    }
}