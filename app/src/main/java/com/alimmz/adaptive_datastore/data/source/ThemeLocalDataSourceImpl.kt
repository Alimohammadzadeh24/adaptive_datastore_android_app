package com.alimmz.adaptive_datastore.data.source

import androidx.datastore.core.DataStore
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class ThemeLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<ThemePreference>
) : ThemeLocalDataSource {
    
    override suspend fun getThemePreference(): ThemePreference {
        return dataStore.data.first()
    }

    override suspend fun saveThemePreference(themePreference: ThemePreference) {
        dataStore.updateData { themePreference }
    }

    override fun observeThemePreference(): Flow<ThemePreference> {
        return dataStore.data
    }
} 