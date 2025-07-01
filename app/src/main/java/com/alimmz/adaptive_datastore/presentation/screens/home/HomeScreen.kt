package com.alimmz.adaptive_datastore.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.alimmz.adaptive_datastore.presentation.screens.navigation.Screens
import com.alimmz.adaptive_datastore.presentation.ui.components.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToOtherScreen: (Screens) -> Unit,
) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val state = viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                Text("All Habits")
        },
            )
        },
        bottomBar = {
            BottomNavigationBar(
                onClickItem = onNavigateToOtherScreen
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            if(state.value.isLoading){
              Text("IsLoading.....")
            }else if(state.value.isError){
                Text("Error...")
            }else {
                if(state.value.dailyHabits.isEmpty()){
                    Text("Empty...")
                }else{
                    LazyColumn {
                        items(state.value.dailyHabits){
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
}