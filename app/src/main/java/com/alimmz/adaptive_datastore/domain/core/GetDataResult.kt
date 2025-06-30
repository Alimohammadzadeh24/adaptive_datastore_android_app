package com.alimmz.adaptive_datastore.domain.core

import com.alimmz.adaptive_datastore.domain.entities.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> getDataResult(
    function: suspend () -> DataResult<T>,
): Flow<DataResult<T>> {
    return flow {
        emit(DataResult.Loading())
        emit(function.invoke())
    }
}
