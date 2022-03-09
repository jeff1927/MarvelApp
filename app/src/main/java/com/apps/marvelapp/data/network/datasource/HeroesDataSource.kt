package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.data.network.dtos.characters.CharacterDataWrapperDto
import com.apps.marvelapp.data.network.dtos.characters.CharacterDto
import com.apps.marvelapp.domain.models.CharacterDataWrapperModel
import com.apps.marvelapp.domain.models.HeroModel
import retrofit2.Response

interface HeroesDataSource {

    suspend fun getCharactersPageList(offset:Int, limit:Int): List<HeroModel>

}