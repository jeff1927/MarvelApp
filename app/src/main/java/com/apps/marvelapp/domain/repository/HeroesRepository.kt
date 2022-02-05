package com.apps.marvelapp.domain.repository

import com.apps.marvelapp.domain.models.HeroModel

interface HeroesRepository {

    suspend fun getHeroesList():List<HeroModel>

}