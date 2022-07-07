package com.apps.marvelapp.domain.repository

import androidx.paging.PagingData
import com.apps.marvelapp.domain.models.CharacterModel
import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getCharactersPageList(): Flow<PagingData<CharacterModel>>

    suspend fun saveCharacter(characterModel: CharacterModel)

    suspend fun getSavedCharacters(): Flow<List<CharacterModel>>

}