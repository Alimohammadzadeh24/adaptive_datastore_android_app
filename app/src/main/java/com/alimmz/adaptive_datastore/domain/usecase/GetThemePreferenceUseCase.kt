package com.alimmz.adaptive_datastore.domain.usecase

import com.alimmz.adaptive_datastore.domain.core.getDataResult
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import com.alimmz.adaptive_datastore.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetThemePreferenceUseCase @Inject constructor(
    private val repository: ThemeRepository,
) {
    operator fun invoke(): Flow<DataResult<ThemePreference>> = getDataResult {
        repository.getThemePreference()
    }
} 