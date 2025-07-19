package com.alimmz.adaptive_datastore.presentation.screens.main.settings

import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import com.alimmz.adaptive_datastore.domain.usecase.GetThemePreferenceUseCase
import com.alimmz.adaptive_datastore.domain.usecase.SaveThemePreferenceUseCase
import com.alimmz.adaptive_datastore.presentation.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getThemePreferenceUseCase: GetThemePreferenceUseCase,
    private val saveThemePreferenceUseCase: SaveThemePreferenceUseCase,
) : BaseViewModel<SettingsUiModel, SettingsUiAction>(SettingsUiModel()) {

    override fun handleIntent(intent: SettingsUiAction) {
        when (intent) {
            is SettingsUiAction.ToggleTheme -> {
                launch {
                    val themePreference = ThemePreference(isDarkTheme = intent.isDarkTheme)
                    saveThemePreferenceUseCase.invoke(themePreference).collect { dataResult ->
                        when (dataResult) {
                            is DataResult.Success -> {
                                updateState {
                                    it.copy(isDarkTheme = intent.isDarkTheme)
                                }
                            }
                            is DataResult.Error -> {
                                updateState {
                                    it.copy(
                                        isError = true,
                                        errorMessage = dataResult.error
                                    )
                                }
                            }
                            is DataResult.Loading -> {
                                // Theme operations are fast, no need for loading state
                            }
                        }
                    }
                }
            }
            
            SettingsUiAction.LoadSettings -> {
                launch {
                    getThemePreferenceUseCase.invoke().collect { dataResult ->
                        when (dataResult) {
                            is DataResult.Success -> {
                                updateState { 
                                    it.copy(
                                        isDarkTheme = dataResult.data?.isDarkTheme ?: false
                                    ) 
                                }
                            }
                            is DataResult.Error -> {
                                updateState { 
                                    it.copy(
                                        isError = true,
                                        errorMessage = dataResult.error
                                    ) 
                                }
                            }
                            is DataResult.Loading -> {
                                // Theme operations are fast, no need for loading state
                            }
                        }
                    }
                }
            }
            
            SettingsUiAction.ClearError -> {
                updateState { 
                    it.copy(
                        isError = false,
                        errorMessage = ""
                    ) 
                }
            }
        }
    }
} 