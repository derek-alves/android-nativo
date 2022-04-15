package com.example.core.usecase.base

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(
): PagingUseCase<GetCharactersUseCase.GetCharactersParams, Character>() {

    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        TODO("Not yet implemented")
    }
    data class GetCharactersParams(val query:String,val pagingConfig: PagingConfig)


}