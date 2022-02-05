package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.data.network.MarvelApi
import com.apps.marvelapp.domain.models.CharacterDataWrapperModel
import javax.inject.Inject

class HeroesDataSourceImpl@Inject constructor(
    private val apiService: MarvelApi
): HeroesDataSource {
    override suspend fun getHeroesList(): CharacterDataWrapperModel {
        return apiService.getAllCharacters().toDomainModel()
    }
}