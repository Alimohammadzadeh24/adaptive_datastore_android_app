package com.alimmz.adaptive_datastore.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alimmz.adaptive_datastore.presentation.screens.navigation.Screens

@Composable
fun BottomNavigationBar(
    onClickItem: (Screens) -> Unit,
) {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {
                onClickItem(Screens.Home)
            },
            icon = { Icons.Default.Home }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                onClickItem(Screens.AddHabit)
            },
            icon = { Icons.Default.Add }
        )
    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview(){
    BottomNavigationBar {

    }
}