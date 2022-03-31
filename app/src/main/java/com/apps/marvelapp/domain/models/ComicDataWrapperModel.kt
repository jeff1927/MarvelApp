package com.apps.marvelapp.domain.models

import com.apps.marvelapp.data.network.dtos.comics.ComicDataContainerDto

data class ComicDataWrapperModel(
    val code: Int,
    val status: String,
    val data: ComicDataContainerDto,
)
