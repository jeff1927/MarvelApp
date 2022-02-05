package com.apps.marvelapp.data.repositoryimpl

import com.apps.marvelapp.data.network.datasource.HeroesDataSource
import com.apps.marvelapp.domain.models.HeroModel
import com.apps.marvelapp.domain.repository.HeroesRepository
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val heroesDataSource: HeroesDataSource
):HeroesRepository{
    override suspend fun getHeroesList(): List<HeroModel> {
        return heroesDataSource.getHeroesList().data.toDomainModel().results
    }
}