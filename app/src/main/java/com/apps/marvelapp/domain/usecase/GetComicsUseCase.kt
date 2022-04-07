package com.apps.marvelapp.domain.usecase

import androidx.paging.PagingData
import com.apps.marvelapp.domain.models.ComicModel
import com.apps.marvelapp.domain.repository.ComicsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val comicsRepository: ComicsRepository
) {
    suspend operator fun invoke(): Flow<PagingData<ComicModel>>{
        return comicsRepository.getComicsPageList()
    }
}