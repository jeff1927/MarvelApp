package com.apps.marvelapp.data.network.datasource

import com.apps.marvelapp.data.network.MarvelApi
import com.apps.marvelapp.domain.models.ComicModel
import javax.inject.Inject

class ComicsDataSourceImpl @Inject constructor(
    private val apiService: MarvelApi
): ComicsDataSource{

    override suspend fun getComicsPageList(offset: Int, limit: Int): List<ComicModel> {

        val modelData = apiService.getAllComics(offset,limit).toDomainModel()

        return modelData.data.toDomainModel().results
    }
}