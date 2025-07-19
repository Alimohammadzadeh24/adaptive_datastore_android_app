package com.alimmz.adaptive_datastore.presentation.core.theme

import com.alimmz.adaptive_datastore.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeManager @Inject constructor(
    private val themeRepository: ThemeRepository
) {
    fun observeThemePreference(): Flow<com.alimmz.adaptive_datastore.domain.entities.ThemePreference> {
        return themeRepository.observeThemePreference()
    }
} 