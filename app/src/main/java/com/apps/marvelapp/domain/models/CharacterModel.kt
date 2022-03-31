package com.apps.marvelapp.domain.models


data class CharacterModel(
    val id: Int,
    val name: String,
    val bio: String,
    val imageExt: String,
    val imagePath: String
)
