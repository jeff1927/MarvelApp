package com.apps.marvelapp.data.network.dtos.characters

import com.apps.marvelapp.domain.models.CharacterDataContainerModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterDataContainerDto(
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
    val results: List<CharacterDto>,
    @Expose
    @SerializedName("total")
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