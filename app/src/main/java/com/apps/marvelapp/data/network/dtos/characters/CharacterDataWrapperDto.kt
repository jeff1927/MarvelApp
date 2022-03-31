package com.apps.marvelapp.data.network.dtos.characters

import com.apps.marvelapp.domain.models.CharacterDataWrapperModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterDataWrapperDto(
    @Expose
    @SerializedName("code")
    val code: Int,
    @Expose
    @SerializedName("data")
    val data: CharacterDataContainerDto,
    @Expose
    @SerializedName("status")
    val status: String
) {
    fun toDomainModel() = CharacterDataWrapperModel(
        code,
        data,
        status
    )
}