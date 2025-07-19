package com.alimmz.adaptive_datastore.presentation.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import com.alimmz.adaptive_datastore.presentation.core.theme.ThemeManager
import com.alimmz.adaptive_datastore.presentation.navigation.DailyHabitNav
import com.alimmz.adaptive_datastore.presentation.ui.theme.Adaptive_datastoreTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var themeManager: ThemeManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themePreference by themeManager.observeThemePreference().collectAsState(
                initial = ThemePreference()
            )
            
            Adaptive_datastoreTheme(
                darkTheme = themePreference.isDarkTheme
            ) {
                DailyHabitNav()
            }
        }
    }
}