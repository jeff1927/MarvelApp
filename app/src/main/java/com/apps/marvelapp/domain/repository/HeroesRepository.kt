package com.apps.marvelapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.apps.marvelapp.domain.models.HeroModel
import kotlinx.coroutines.flow.Flow

interface HeroesRepository {

    suspend fun getHeroesPageList():Flow<PagingData<HeroModel>>

}