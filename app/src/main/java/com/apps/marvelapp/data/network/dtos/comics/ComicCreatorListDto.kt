package com.apps.marvelapp.data.network.dtos.comics

import com.apps.marvelapp.domain.models.ComicCreatorModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicCreatorListDto(
    @Expose
    @SerializedName("items")
    val creators: List<ComicCreatorDto>,
)
