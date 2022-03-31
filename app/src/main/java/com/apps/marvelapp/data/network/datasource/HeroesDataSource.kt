package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.domain.models.CharacterModel

interface HeroesDataSource {

    suspend fun getCharactersPageList(offset:Int, limit:Int): List<CharacterModel>

}