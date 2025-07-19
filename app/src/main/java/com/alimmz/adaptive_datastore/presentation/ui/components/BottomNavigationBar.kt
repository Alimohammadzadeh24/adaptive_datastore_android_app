package com.alimmz.adaptive_datastore.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alimmz.adaptive_datastore.presentation.navigation.Screen

@Composable
fun BottomNavigationBar(
    selectedScreen: Screen,
    onClickItem: (Screen) -> Unit,
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedScreen == Screen.Home,
            label = {
                Text("Home")
            },
            onClick = {
                onClickItem(Screen.Home)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon"
                )
            }
        )
        NavigationBarItem(
            selected = selectedScreen == Screen.AddHabit,
            label = {
                Text("Add")
            },
            onClick = {
                onClickItem(Screen.AddHabit)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Icon"
                )
            }
        )
        NavigationBarItem(
            selected = selectedScreen == Screen.Settings,
            label = {
                Text("Settings")
            },
            onClick = {
                onClickItem(Screen.Settings)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings Icon"
                )
            }
        )
    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        selectedScreen = Screen.Home,
        onClickItem = {}
    )
}