package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.data.network.dtos.characters.CharacterDataWrapperDto
import com.apps.marvelapp.domain.models.CharacterDataWrapperModel
import retrofit2.Response

interface HeroesDataSource {

    suspend fun getHeroesList(): CharacterDataWrapperModel

}