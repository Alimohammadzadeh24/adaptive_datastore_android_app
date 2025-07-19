package com.alimmz.adaptive_datastore.presentation.screens.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeViewModel>()
    val state = viewModel.state.collectAsState()

    Column {
        if (state.value.isLoading) {
            Text("IsLoading.....")
        } else if (state.value.isError) {
            Text("Error...")
        } else {
            if (state.value.dailyHabits.isEmpty()) {
                Text("Empty...")
            } else {
                LazyColumn {
                    items(state.value.dailyHabits) {
                        Column {
                            Text(it.title)
                            Text(it.description)
                        }
                    }
                }
            }
        }
    }
}