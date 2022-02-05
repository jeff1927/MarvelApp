package com.apps.marvelapp.data.network.dtos.characters

import com.apps.marvelapp.domain.models.HeroModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterDto(

    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: ImageDto
){
    fun toDomainModel()= HeroModel(
        id,
        name,
        description,
        thumbnail.extension,
        thumbnail.path
    )
}