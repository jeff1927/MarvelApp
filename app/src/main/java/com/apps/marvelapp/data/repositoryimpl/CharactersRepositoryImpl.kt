package com.apps.marvelapp.data.repositoryimpl


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.filter
import com.apps.marvelapp.data.local.AppDataBase
import com.apps.marvelapp.data.local.CharactersDao
import com.apps.marvelapp.data.network.datasource.HeroesDataSource
import com.apps.marvelapp.data.network.datasource.HeroesPagingSource
import com.apps.marvelapp.domain.constants.CHARACTERS_PAGE_SIZE
import com.apps.marvelapp.domain.models.CharacterModel
import com.apps.marvelapp.domain.repository.CharactersRepository
import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class CharactersRepositoryImpl @Inject constructor(
    private val heroesDataSource: HeroesDataSource,
    private val charactersDao: CharactersDao
):CharactersRepository {

    override suspend fun getCharactersPageList(): Flow<PagingData<CharacterModel>> {
        return Pager(
                config = PagingConfig(
                    pageSize = CHARACTERS_PAGE_SIZE,
                    enablePlaceholders = false,
                ),
                pagingSourceFactory = {
                    HeroesPagingSource(heroesDataSource)
                }
            ).flow.map { pagingData->
            pagingData.filter { it.imagePath != "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available" }
        }
    }

    override suspend fun saveCharacter(characterModel: CharacterModel) {
        charactersDao.upsert(characterModel)
    }

    override suspend fun getSavedCharacters() = flow {
        emit(charactersDao.getAllCharacters())
    }
}