package com.apps.marvelapp.data.network.dtos.comics

import com.apps.marvelapp.domain.models.ComicDataWrapperModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicDataWrapperDto(
    @Expose
    @SerializedName("code")
    val code: Int,
    @Expose
    @SerializedName("status")
    val status: String,
    @Expose
    @SerializedName("data")
    val data: ComicDataContainerDto,
){
    fun toDomainModel() = ComicDataWrapperModel(
        code,
        status,
        data
    )
}
