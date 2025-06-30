package com.alimmz.adaptive_datastore.domain.usecase

import com.alimmz.adaptive_datastore.domain.core.getDataResult
import com.alimmz.adaptive_datastore.domain.entities.DailyHabit
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.repository.DailyHabitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddDailyHabitUseCase @Inject constructor(
    private val repository: DailyHabitRepository,
) {
    operator fun invoke(habit: DailyHabit) : Flow<DataResult<Unit>> = getDataResult {
        repository.addDailyHabit(habit = habit)
    }
}