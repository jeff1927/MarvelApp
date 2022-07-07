package com.apps.marvelapp.domain.usecase

import androidx.paging.PagingData
import com.apps.marvelapp.domain.models.CharacterModel
import com.apps.marvelapp.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersListUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(): Flow<PagingData<CharacterModel>> {
        return charactersRepository.getCharactersPageList()
    }
}