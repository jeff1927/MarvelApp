package com.apps.marvelapp.data.network.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apps.marvelapp.domain.constants.COMICS_PAGE_SIZE
import com.apps.marvelapp.domain.constants.ONE_UNIT
import com.apps.marvelapp.domain.models.ComicModel
import retrofit2.HttpException
import java.io.IOException

private const val COMICS_PAGE_INDEX = 1

class ComicsPagingSource(private val datasource:ComicsDataSource):PagingSource<Int, ComicModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ComicModel> {
        val position = params.key ?: COMICS_PAGE_INDEX
        val offset = if (params.key != null)((position - ONE_UNIT) * COMICS_PAGE_SIZE) + ONE_UNIT else COMICS_PAGE_INDEX
        return try {
            val response = datasource.getComicsPageList(offset, params.loadSize)
            val nextKey = if (response.size < params.loadSize) null else (position + (params.loadSize / COMICS_PAGE_SIZE))
            LoadResult.Page(response,null, nextKey)
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, ComicModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition)?: return null
        return page.prevKey?.plus(ONE_UNIT)?: page.nextKey?.minus(ONE_UNIT)
    }
}