package com.alimmz.adaptive_datastore.data.repository

import com.alimmz.adaptive_datastore.data.core.safeCall
import com.alimmz.adaptive_datastore.data.source.ThemeLocalDataSource
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import com.alimmz.adaptive_datastore.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ThemeRepositoryImpl @Inject constructor(
    private val dataSource: ThemeLocalDataSource,
) : ThemeRepository {
    
    override suspend fun getThemePreference(): DataResult<ThemePreference> {
        return safeCall {
            dataSource.getThemePreference()
        }
    }

    override suspend fun saveThemePreference(themePreference: ThemePreference): DataResult<Unit> {
        return safeCall {
            dataSource.saveThemePreference(themePreference)
        }
    }

    override fun observeThemePreference(): Flow<ThemePreference> {
        return dataSource.observeThemePreference()
    }
} 