package com.apps.marvelapp.data.network.dtos.comics

import com.apps.marvelapp.data.network.dtos.characters.CharacterDto
import com.apps.marvelapp.domain.models.ComicDataContainerModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicDataContainerDto(
    @Expose
    @SerializedName("count")
    val count: Int,
    @Expose
    @SerializedName("limit")
    val limit: Int,
    @Expose
    @SerializedName("offset")
    val offset: Int,
    @Expose
    @SerializedName("results")
    val results: List<ComicDto>,
    @Expose
    @SerializedName("total")
    val total: Int
){
    fun toDomainModel() = ComicDataContainerModel(
        count,
        limit,
        offset,
        results.map { it.toDomainModel() },
        total
    )
}