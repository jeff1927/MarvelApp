package com.apps.marvelapp.data.network

import com.apps.marvelapp.BuildConfig
import com.apps.marvelapp.data.network.dtos.characters.CharacterDataWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("v1/public/characters")
    suspend fun getAllCharacters(
        @Query("orderBy")
        orderBy: String = "name",
        @Query("limit")
        pageSize: Int = 30,
        @Query("ts")
        ts: Long = 1,
        @Query("apikey")
        apiKey: String = BuildConfig.PUBLIC_API_KEY,
        @Query("hash")
        hash: String = BuildConfig.HASH_CODE
    ): CharacterDataWrapperDto



}