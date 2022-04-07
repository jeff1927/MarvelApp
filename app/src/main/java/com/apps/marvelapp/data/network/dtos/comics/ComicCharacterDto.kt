package com.apps.marvelapp.data.network.dtos.comics

import com.apps.marvelapp.domain.models.ComicCharacterModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicCharacterDto(
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("role")
    val role: String? = null,
){
    fun toDomainModel() = ComicCharacterModel(
        name,
        role
    )
}
