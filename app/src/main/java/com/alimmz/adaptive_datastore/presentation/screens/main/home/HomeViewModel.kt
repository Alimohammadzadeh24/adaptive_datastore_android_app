package com.alimmz.adaptive_datastore.presentation.screens.main.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.usecase.GetDailyHabitsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDailyHabitsListUseCase: GetDailyHabitsListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiModel())
    val state = _state.asStateFlow()

    fun sendIntent(intent: HomeUiAction) {
        handleIntent(intent)
    }

    private fun handleIntent(intent: HomeUiAction) {
        when (intent) {
            HomeUiAction.GetDailyHabitsList -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(
                            dailyHabits = mutableStateListOf()
                        )
                    }
                    getDailyHabitsListUseCase.invoke().collect { dataResult ->
                        when (dataResult) {
                            is DataResult.Loading -> _state.update {
                                it.copy(
                                    isLoading = true,
                                    isError = false,
                                )
                            }

                            is DataResult.Error -> {
                                _state.update {
                                    it.copy(
                                        isError = true,
                                        isLoading = false,
                                    )
                                }
                            }

                            is DataResult.Success -> {
                                _state.update {
                                    it.copy(
                                        isLoading = false,
                                        isError = false,
                                        dailyHabits = dataResult.data?.habits?.toMutableStateList()
                                            ?: mutableStateListOf()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}