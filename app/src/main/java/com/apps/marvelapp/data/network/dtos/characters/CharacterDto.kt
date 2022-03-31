package com.apps.marvelapp.data.network.dtos.characters

import com.apps.marvelapp.domain.models.CharacterModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("thumbnail")
    val thumbnail: CharacterImageDto
){
    fun toDomainModel()= CharacterModel(
        id,
        name,
        description,
        thumbnail.extension,
        thumbnail.path
    )
}