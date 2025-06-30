package com.alimmz.adaptive_datastore.domain.usecase

import com.alimmz.adaptive_datastore.domain.core.getDataResult
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.repository.DailyHabitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClearDataHabitsListUseCase @Inject constructor(
    private val repository: DailyHabitRepository,
) {
    operator fun invoke() : Flow<DataResult<Unit>> = getDataResult {
        repository.clearDailyHabits()
    }
}