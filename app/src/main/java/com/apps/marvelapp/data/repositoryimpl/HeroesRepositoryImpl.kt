package com.apps.marvelapp.data.repositoryimpl


import androidx.lifecycle.LiveData
import androidx.paging.*
import com.apps.marvelapp.data.network.MarvelApi
import com.apps.marvelapp.data.network.datasource.HeroesDataSource
import com.apps.marvelapp.data.network.datasource.HeroesPagingSource
import com.apps.marvelapp.domain.constants.NETWORK_PAGE_SIZE
import com.apps.marvelapp.domain.models.HeroModel
import com.apps.marvelapp.domain.repository.HeroesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val heroesDataSource: HeroesDataSource
):HeroesRepository{

    override suspend fun getHeroesPageList(): Flow<PagingData<HeroModel>> {
        return Pager(
                config = PagingConfig(
                    pageSize = NETWORK_PAGE_SIZE,
                    enablePlaceholders = false,
                ),
                pagingSourceFactory = {
                    HeroesPagingSource(heroesDataSource)
                }
            ).flow
    }
}