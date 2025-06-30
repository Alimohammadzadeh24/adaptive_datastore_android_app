package com.alimmz.adaptive_datastore.domain.entities

sealed interface  DataResult<out T> {
    data class Success<out T>(val data: T?) : DataResult<T>
    data class Error(val error: String) : DataResult<Nothing>
    class Loading<out T> : DataResult<T>
}