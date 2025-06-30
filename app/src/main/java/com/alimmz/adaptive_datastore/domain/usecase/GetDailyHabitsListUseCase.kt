package com.alimmz.adaptive_datastore.domain.usecase

import com.alimmz.adaptive_datastore.domain.core.getDataResult
import com.alimmz.adaptive_datastore.domain.entities.DailyHabitsList
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.repository.DailyHabitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDailyHabitsListUseCase @Inject constructor(
    private val repository: DailyHabitRepository,
) {
    operator fun invoke() : Flow<DataResult<DailyHabitsList>> = getDataResult {
        repository.getDailyHabits()
    }
}