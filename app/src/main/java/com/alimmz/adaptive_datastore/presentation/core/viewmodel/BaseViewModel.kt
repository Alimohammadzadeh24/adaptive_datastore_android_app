package com.alimmz.adaptive_datastore.presentation.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Generic BaseViewModel that implements MVI pattern
 * @param State The UI state type
 * @param Intent The user intent type
 * @param initialState The initial state for the ViewModel
 */
abstract class BaseViewModel<State, Intent>(
    private val initialState: State
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    /**
     * Send an intent to the ViewModel
     * @param intent The user intent to process
     */
    fun sendIntent(intent: Intent) {
        handleIntent(intent)
    }

    /**
     * Handle the user intent and update state accordingly
     * @param intent The user intent to handle
     */
    protected abstract fun handleIntent(intent: Intent)

    /**
     * Update the current state
     * @param update Lambda to update the current state
     */
    protected fun updateState(update: (State) -> State) {
        _state.update(update)
    }

    /**
     * Launch a coroutine in the ViewModel scope
     * @param block The coroutine block to execute
     */
    protected fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            block()
        }
    }

    /**
     * Get the current state value
     * @return The current state
     */
    protected fun getCurrentState(): State = _state.value
}