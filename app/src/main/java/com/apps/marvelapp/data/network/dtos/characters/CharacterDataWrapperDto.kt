package com.apps.marvelapp.data.network.dtos.characters

import com.apps.marvelapp.domain.models.CharacterDataWrapperModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterDataWrapperDto(
    @SerializedName("code")
    @Expose
    val code: Int,
    @SerializedName("data")
    @Expose
    val data: CharacterDataContainerDto,
    @SerializedName("status")
    @Expose
    val status: String
) {
    fun toDomainModel() = CharacterDataWrapperModel(
        code = code,
        data = data,
        status = status
    )
}