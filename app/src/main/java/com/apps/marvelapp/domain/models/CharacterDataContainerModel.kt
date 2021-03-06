package com.apps.marvelapp.domain.models

data class CharacterDataContainerModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<CharacterModel>,
    val total: Int
)
