package com.apps.marvelapp.data.network.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apps.marvelapp.domain.constants.NETWORK_PAGE_SIZE
import com.apps.marvelapp.domain.constants.ONE_UNIT
import com.apps.marvelapp.domain.models.CharacterModel
import retrofit2.HttpException
import java.io.IOException

private const val HEROES_PAGE_INDEX = 1

class HeroesPagingSource(
    private val dataSource: HeroesDataSource
    ): PagingSource<Int, CharacterModel>(){
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val position = params.key ?: HEROES_PAGE_INDEX
        val offset = if (params.key != null) ((position - ONE_UNIT) * NETWORK_PAGE_SIZE) + ONE_UNIT else  HEROES_PAGE_INDEX
        return try {
            val response = dataSource.getCharactersPageList(offset,params.loadSize)
            val nextKey = if (response.size < params.loadSize) null else (position + (params.loadSize / NETWORK_PAGE_SIZE))
            LoadResult.Page(response, null, nextKey = nextKey)
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }

    }
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition)?: return null
        return page.prevKey?.plus(ONE_UNIT)?: page.nextKey?.minus(ONE_UNIT)
    }
}