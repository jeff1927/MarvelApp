package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.domain.models.ComicModel

interface ComicsDataSource {

    suspend fun getComicsPageList(offset:Int, limit: Int): List<ComicModel>

}