package com.apps.marvelapp.domain.models

import com.apps.marvelapp.data.network.dtos.characters.CharacterDataContainerDto

data class CharacterDataWrapperModel(
    val code: Int,
    val data: CharacterDataContainerDto,
    val status: String
)
