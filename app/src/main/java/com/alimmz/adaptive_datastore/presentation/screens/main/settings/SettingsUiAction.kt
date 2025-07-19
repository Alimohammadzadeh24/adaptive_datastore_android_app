package com.alimmz.adaptive_datastore.presentation.screens.main.settings

sealed interface SettingsUiAction {
    data class ToggleTheme(val isDarkTheme: Boolean) : SettingsUiAction
    data object LoadSettings : SettingsUiAction
    data object ClearError : SettingsUiAction
} 