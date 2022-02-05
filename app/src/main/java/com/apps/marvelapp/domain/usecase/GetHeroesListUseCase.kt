package com.apps.marvelapp.domain.usecase

import com.apps.marvelapp.domain.models.HeroModel
import com.apps.marvelapp.domain.repository.HeroesRepository
import javax.inject.Inject

class GetHeroesListUseCase @Inject constructor(
    private val heroesRepository: HeroesRepository
) {
    suspend fun getHeroesList() : List<HeroModel>{
        return heroesRepository.getHeroesList()
    }
}