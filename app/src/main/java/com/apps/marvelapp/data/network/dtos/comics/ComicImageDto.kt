package com.apps.marvelapp.data.network.dtos.comics

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicImageDto(
    @Expose
    @SerializedName("extension")
    val extension: String,
    @Expose
    @SerializedName("path")
    val path: String
)
