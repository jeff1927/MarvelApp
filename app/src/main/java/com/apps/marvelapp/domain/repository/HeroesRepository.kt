package com.apps.marvelapp.domain.repository

import androidx.paging.PagingData
import com.apps.marvelapp.domain.models.CharacterModel
import kotlinx.coroutines.flow.Flow

interface HeroesRepository {

    suspend fun getHeroesPageList():Flow<PagingData<CharacterModel>>

}