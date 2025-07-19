package com.alimmz.adaptive_datastore.presentation.screens.main.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import com.alimmz.adaptive_datastore.domain.entities.DataResult
import com.alimmz.adaptive_datastore.domain.usecase.DeleteDailyHabitUseCase
import com.alimmz.adaptive_datastore.domain.usecase.GetDailyHabitsListUseCase
import com.alimmz.adaptive_datastore.domain.usecase.ToggleHabitDoneStatusUseCase
import com.alimmz.adaptive_datastore.presentation.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDailyHabitsListUseCase: GetDailyHabitsListUseCase,
    private val toggleHabitDoneStatusUseCase: ToggleHabitDoneStatusUseCase,
    private val deleteDailyHabitUseCase: DeleteDailyHabitUseCase,
) : BaseViewModel<HomeUiModel, HomeUiAction>(HomeUiModel()) {

    override fun handleIntent(intent: HomeUiAction) {
        when (intent) {
            HomeUiAction.GetDailyHabitsList -> {
                launch {
                    updateState {
                        it.copy(
                            dailyHabits = mutableStateListOf()
                        )
                    }
                    getDailyHabitsListUseCase.invoke().collect { dataResult ->
                        when (dataResult) {
                            is DataResult.Loading -> updateState {
                                it.copy(
                                    isLoading = true,
                                    isError = false,
                                )
                            }

                            is DataResult.Error -> {
                                updateState {
                                    it.copy(
                                        isError = true,
                                        isLoading = false,
                                    )
                                }
                            }

                            is DataResult.Success -> {
                                updateState {
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
            
            is HomeUiAction.ToggleHabitDoneStatus -> {
                launch {
                    toggleHabitDoneStatusUseCase.invoke(intent.habit).collect { dataResult ->
                        when (dataResult) {
                            is DataResult.Success -> {
                                // Refresh the habits list after toggle
                                sendIntent(HomeUiAction.GetDailyHabitsList)
                            }
                            is DataResult.Error -> {
                                updateState {
                                    it.copy(isError = true)
                                }
                            }
                            is DataResult.Loading -> {
                                // Optional: Show loading state for toggle
                            }
                        }
                    }
                }
            }
            
            is HomeUiAction.DeleteHabit -> {
                launch {
                    deleteDailyHabitUseCase.invoke(intent.habit).collect { dataResult ->
                        when (dataResult) {
                            is DataResult.Success -> {
                                // Refresh the habits list after deletion
                                sendIntent(HomeUiAction.GetDailyHabitsList)
                            }
                            is DataResult.Error -> {
                                updateState {
                                    it.copy(isError = true)
                                }
                            }
                            is DataResult.Loading -> {
                                // Optional: Show loading state for deletion
                            }
                        }
                    }
                }
            }
        }
    }
}