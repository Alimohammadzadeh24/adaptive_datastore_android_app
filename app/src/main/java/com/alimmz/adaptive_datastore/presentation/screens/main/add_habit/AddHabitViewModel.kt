package com.alimmz.adaptive_datastore.presentation.screens.main.add_habit

import com.alimmz.adaptive_datastore.domain.entities.DailyHabit
import com.alimmz.adaptive_datastore.domain.usecase.AddDailyHabitUseCase
import com.alimmz.adaptive_datastore.presentation.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddHabitViewModel @Inject constructor(
    private val addDailyHabitUseCase: AddDailyHabitUseCase,
) : BaseViewModel<AddHabitUiModel, AddHabitUiAction>(AddHabitUiModel()) {

    override fun handleIntent(intent: AddHabitUiAction) {
        when (intent) {
            is AddHabitUiAction.UpdateTitle -> {
                updateState {
                    it.copy(title = intent.title)
                }
            }
            
            is AddHabitUiAction.UpdateDescription -> {
                updateState {
                    it.copy(description = intent.description)
                }
            }
            
            AddHabitUiAction.SaveHabit -> {
                val currentState = getCurrentState()
                if (currentState.title.isNotBlank()) {
                    launch {
                        val habit = DailyHabit(
                            title = currentState.title,
                            description = currentState.description,
                            createdAt = System.currentTimeMillis().toString(),
                            updatedAt = System.currentTimeMillis().toString(),
                            isDone = false
                        )
                        
                        addDailyHabitUseCase.invoke(habit).collect { result ->
                            when (result) {
                                is com.alimmz.adaptive_datastore.domain.entities.DataResult.Loading -> {
                                    updateState { it.copy(isLoading = true, isError = false) }
                                }
                                is com.alimmz.adaptive_datastore.domain.entities.DataResult.Success -> {
                                    updateState { 
                                        it.copy(
                                            isLoading = false, 
                                            isError = false,
                                            isSuccess = true,
                                            title = "",
                                            description = ""
                                        ) 
                                    }
                                }
                                is com.alimmz.adaptive_datastore.domain.entities.DataResult.Error -> {
                                    updateState { 
                                        it.copy(
                                            isLoading = false, 
                                            isError = true,
                                            errorMessage = result.error
                                        ) 
                                    }
                                }
                            }
                        }
                    }
                } else {
                    updateState { it.copy(isError = true, errorMessage = "Title cannot be empty") }
                }
            }
            
            AddHabitUiAction.ClearError -> {
                updateState { it.copy(isError = false, errorMessage = "") }
            }
            
            AddHabitUiAction.ClearSuccess -> {
                updateState { it.copy(isSuccess = false) }
            }
        }
    }
}