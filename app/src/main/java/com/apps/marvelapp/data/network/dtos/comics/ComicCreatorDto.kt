package com.apps.marvelapp.data.network.dtos.comics

import com.apps.marvelapp.domain.models.ComicCreatorModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicCreatorDto(
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("role")
    val role: String,
){
    fun toDomainModel() = ComicCreatorModel(
        name,
        role
    )
}
