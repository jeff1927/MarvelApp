package com.apps.marvelapp.domain.repository

import androidx.paging.PagingData
import com.apps.marvelapp.domain.models.ComicModel
import kotlinx.coroutines.flow.Flow

interface ComicsRepository {

    suspend fun getComicsPageList(): Flow<PagingData<ComicModel>>

}