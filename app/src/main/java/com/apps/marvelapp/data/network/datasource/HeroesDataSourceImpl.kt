package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.data.network.MarvelApi
import com.apps.marvelapp.data.network.dtos.characters.CharacterDto
import com.apps.marvelapp.domain.models.CharacterDataWrapperModel
import com.apps.marvelapp.domain.models.HeroModel
import javax.inject.Inject

class HeroesDataSourceImpl@Inject constructor(
    private val apiService: MarvelApi
): HeroesDataSource {

    override suspend fun getCharactersPageList(offset: Int, limit: Int): List<HeroModel> {
        val results: List<HeroModel>
        apiService.getAllCharacters(offset,limit).let {
            val modelData = it.toDomainModel()
            results = modelData.data.toDomainModel().results
        }
        return results
    }
}