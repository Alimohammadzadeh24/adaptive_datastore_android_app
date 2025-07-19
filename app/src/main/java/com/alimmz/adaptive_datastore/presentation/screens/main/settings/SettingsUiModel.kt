package com.alimmz.adaptive_datastore.presentation.screens.main.settings

data class SettingsUiModel(
    val isDarkTheme: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
) 