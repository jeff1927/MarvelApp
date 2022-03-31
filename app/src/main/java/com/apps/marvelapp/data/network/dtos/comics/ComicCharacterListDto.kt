package com.apps.marvelapp.data.network.dtos.comics

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicCharacterListDto(
    @Expose
    @SerializedName("items")
    val items: List<ComicCharacterDto>,
)
