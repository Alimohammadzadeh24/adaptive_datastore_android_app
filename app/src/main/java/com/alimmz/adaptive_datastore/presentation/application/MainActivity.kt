package com.alimmz.adaptive_datastore.presentation.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alimmz.adaptive_datastore.presentation.screens.navigation.DailyHabitNav
import com.alimmz.adaptive_datastore.presentation.ui.theme.Adaptive_datastoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Adaptive_datastoreTheme {
                DailyHabitNav()
            }
        }
    }
}