package com.apps.marvelapp.data.network.dtos.characters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("extension")
    @Expose
    val extension: String,
    @SerializedName("path")
    @Expose
    val path: String
)