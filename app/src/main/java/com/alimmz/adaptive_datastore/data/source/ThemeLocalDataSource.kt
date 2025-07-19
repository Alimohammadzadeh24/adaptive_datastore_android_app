package com.alimmz.adaptive_datastore.data.source

import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import kotlinx.coroutines.flow.Flow

interface ThemeLocalDataSource {
    suspend fun getThemePreference(): ThemePreference
    suspend fun saveThemePreference(themePreference: ThemePreference)
    fun observeThemePreference(): Flow<ThemePreference>
} 