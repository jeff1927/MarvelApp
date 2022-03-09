package com.apps.marvelapp.data.network

import com.apps.marvelapp.BuildConfig
import com.apps.marvelapp.data.network.dtos.characters.CharacterDataWrapperDto
import com.apps.marvelapp.domain.constants.CHARACTERS_URL
import com.apps.marvelapp.domain.constants.LIMIT
import com.apps.marvelapp.domain.constants.OFFSET
import com.apps.marvelapp.domain.constants.QUERY_API_KEY
import com.apps.marvelapp.domain.constants.QUERY_HASH
import com.apps.marvelapp.domain.constants.QUERY_LIMIT
import com.apps.marvelapp.domain.constants.QUERY_OFFSET
import com.apps.marvelapp.domain.constants.QUERY_TS
import com.apps.marvelapp.domain.constants.TS
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET(CHARACTERS_URL)
    suspend fun getAllCharacters(
        @Query(QUERY_OFFSET)
        offset: Int = OFFSET,
        @Query(QUERY_LIMIT)
        limit: Int = LIMIT,
        @Query(QUERY_TS)
        ts: Long = TS,
        @Query(QUERY_API_KEY)
        apiKey: String = BuildConfig.PUBLIC_API_KEY,
        @Query(QUERY_HASH)
        hash: String = BuildConfig.HASH_CODE
    ): CharacterDataWrapperDto
}