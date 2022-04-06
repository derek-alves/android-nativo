package com.example.core.usecase.base

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class UseCase<in Params, out Response> {
    operator fun invoke(params: Params):Flow<ResultStatus<Response>> = flow{
        emit(ResultStatus.Loading)
        emit(doWork(params))
    }.catch { throwable ->
        emit(ResultStatus.Error(throwable))
    }

    protected abstract suspend fun doWork(params: Params):ResultStatus<Response>
}

abstract class PagingUseCase<in Params,  Response:Any> {
    operator fun invoke(params: Params):Flow<PagingData<Response>> = createFlowObservable(params)

    protected abstract  fun createFlowObservable(params: Params):Flow<PagingData<Response>>
}