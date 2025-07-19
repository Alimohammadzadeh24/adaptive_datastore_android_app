package com.alimmz.adaptive_datastore.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class ThemePreference(
    val isDarkTheme: Boolean = false
) 