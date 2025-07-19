package com.alimmz.adaptive_datastore.domain.repository

import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    suspend fun getThemePreference(): DataResult<ThemePreference>
    suspend fun saveThemePreference(themePreference: ThemePreference): DataResult<Unit>
    fun observeThemePreference(): Flow<ThemePreference>
} 