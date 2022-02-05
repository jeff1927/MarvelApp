package com.apps.marvelapp.data.network.dtos.characters

import com.apps.marvelapp.domain.models.CharacterDataContainerModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterDataContainerDto(
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("limit")
    @Expose
    val limit: Int,
    @SerializedName("offset")
    @Expose
    val offset: Int,
    @SerializedName("results")
    @Expose
    val results: List<CharacterDto>,
    @SerializedName("total")
    @Expose
    val total: Int
) {
    fun toDomainModel() = CharacterDataContainerModel(
        count,
        limit,
        offset,
        results.map{ it.toDomainModel() },
        total
    )
}