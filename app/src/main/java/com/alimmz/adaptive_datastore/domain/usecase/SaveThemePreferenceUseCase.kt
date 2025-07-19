package com.alimmz.adaptive_datastore.domain.usecase

import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import com.alimmz.adaptive_datastore.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveThemePreferenceUseCase @Inject constructor(
    private val repository: ThemeRepository,
) {
    operator fun invoke(themePreference: ThemePreference): Flow<DataResult<Unit>> = flow {
        try {
            repository.saveThemePreference(themePreference)
            emit(DataResult.Success(Unit))
        } catch (e: Exception) {
            emit(DataResult.Error(e.message ?: "Failed to save theme preference"))
        }
    }
} 