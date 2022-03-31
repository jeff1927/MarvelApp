package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.data.network.MarvelApi
import com.apps.marvelapp.domain.models.CharacterModel
import javax.inject.Inject

class HeroesDataSourceImpl@Inject constructor(
    private val apiService: MarvelApi
): HeroesDataSource {

    override suspend fun getCharactersPageList(offset: Int, limit: Int): List<CharacterModel> {

        val modelData = apiService.getAllCharacters(offset, limit).toDomainModel()

        return modelData.data.toDomainModel().results
    }
}