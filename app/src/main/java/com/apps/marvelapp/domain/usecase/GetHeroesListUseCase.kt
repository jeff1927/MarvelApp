package com.apps.marvelapp.domain.usecase

import androidx.paging.PagingData
import com.apps.marvelapp.domain.models.HeroModel
import com.apps.marvelapp.domain.repository.HeroesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHeroesListUseCase @Inject constructor(
    private val heroesRepository: HeroesRepository
) {
    suspend operator fun invoke(): Flow<PagingData<HeroModel>> {
        return heroesRepository.getHeroesPageList()
    }
}