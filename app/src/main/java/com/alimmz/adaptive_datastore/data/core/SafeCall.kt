package com.alimmz.adaptive_datastore.data.core

import com.alimmz.adaptive_datastore.domain.entities.DataResult

suspend fun <T> safeCall(block: suspend () -> T): DataResult<T> {
    return try {
        DataResult.Success(block())
    } catch (e: Throwable) {
        DataResult.Error(e.message ?: "Something went wrong")
    }
}