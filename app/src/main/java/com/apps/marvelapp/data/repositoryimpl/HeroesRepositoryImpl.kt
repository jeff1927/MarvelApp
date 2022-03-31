package com.apps.marvelapp.data.repositoryimpl


import androidx.paging.*
import com.apps.marvelapp.data.network.datasource.HeroesDataSource
import com.apps.marvelapp.data.network.datasource.HeroesPagingSource
import com.apps.marvelapp.domain.constants.NETWORK_PAGE_SIZE
import com.apps.marvelapp.domain.models.CharacterModel
import com.apps.marvelapp.domain.repository.HeroesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val heroesDataSource: HeroesDataSource
):HeroesRepository{

    override suspend fun getHeroesPageList(): Flow<PagingData<CharacterModel>> {
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