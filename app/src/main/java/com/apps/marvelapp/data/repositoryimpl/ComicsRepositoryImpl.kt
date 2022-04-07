package com.apps.marvelapp.data.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.filter
import com.apps.marvelapp.data.network.datasource.ComicsDataSource
import com.apps.marvelapp.data.network.datasource.ComicsPagingSource
import com.apps.marvelapp.domain.constants.COMICS_PAGE_SIZE
import com.apps.marvelapp.domain.models.ComicModel
import com.apps.marvelapp.domain.repository.ComicsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    private val comicDataSource: ComicsDataSource
):ComicsRepository {

    override suspend fun getComicsPageList(): Flow<PagingData<ComicModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = COMICS_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ComicsPagingSource(comicDataSource)
            }
        ).flow.map { pagingData->
            pagingData.filter { it.ImagePath != "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available" }
        }
    }
}