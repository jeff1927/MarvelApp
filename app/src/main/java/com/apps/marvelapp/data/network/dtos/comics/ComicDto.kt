package com.apps.marvelapp.data.network.dtos.comics

import com.apps.marvelapp.domain.models.ComicModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicDto(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("creators")
    val creators: ComicCreatorListDto,
    @Expose
    @SerializedName("characters")
    val characters: ComicCharacterListDto,
    @Expose
    @SerializedName("thumbnail")
    val thumbnail: ComicImageDto,
){
    fun toDomainModel() = ComicModel(
        id,
        title,
        description,
        creators.creators.map { it.toDomainModel() },
        characters.items.map { it.toDomainModel() },
        thumbnail.extension,
        thumbnail.path
    )
}