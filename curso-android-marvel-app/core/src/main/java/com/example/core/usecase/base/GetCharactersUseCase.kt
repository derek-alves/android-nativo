package com.example.core.usecase.base

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.repository.CharactersRepository
import com.example.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(
    private val charactersRepository: CharactersRepository
): PagingUseCase<GetCharactersUseCase.GetCharactersParams, Character>() {

    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig){
            charactersRepository.getCharacters(params.query)
        }.flow
    }
    data class GetCharactersParams(val query:String,val pagingConfig: PagingConfig)


}