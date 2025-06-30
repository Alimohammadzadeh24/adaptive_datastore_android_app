package com.alimmz.adaptive_datastore.data.source

import androidx.datastore.core.DataStore
import com.alimmz.adaptive_datastore.domain.entities.DailyHabit
import com.alimmz.adaptive_datastore.domain.entities.DailyHabitsList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DailyHabitLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<DailyHabitsList>
) : DailyHabitLocalDataSource {
    override suspend fun addDailyHabit(habit: DailyHabit) {
        dataStore.updateData { dailyHabitsList ->
            if (dailyHabitsList.habits.contains(habit)) {
                dailyHabitsList
            } else {
                dailyHabitsList.copy(habits = dailyHabitsList.habits + habit)
            }
        }
    }

    override suspend fun getDailyHabits(): Flow<DailyHabitsList> {
        return dataStore.data
    }

    override suspend fun updateDailyHabit(habit: DailyHabit) {
        dataStore.updateData { list: DailyHabitsList ->
            list.copy(
                habits = list.habits.map {
                    if (it.title == habit.title) habit else it
                }
            )
        }
    }

    override suspend fun deleteDailyHabit(habit: DailyHabit) {
        dataStore.updateData { list: DailyHabitsList ->
            list.copy(
                habits = list.habits.filter { it.title != habit.title }
            )
        }
    }

    override suspend fun clearDailyHabits() {
        dataStore.updateData { list: DailyHabitsList ->
            list.copy(
                habits = emptyList()
            )
        }
    }

    override suspend fun toggleHabitDoneStatus(habit: DailyHabit) {
        dataStore.updateData { list: DailyHabitsList ->
            list.copy(
                habits = list.habits.map {
                    if (it.title == habit.title) it.copy(
                        isDone = !it.isDone
                    ) else it
                }
            )
        }
    }

}