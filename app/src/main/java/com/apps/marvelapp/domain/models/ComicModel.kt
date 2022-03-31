package com.apps.marvelapp.domain.models

data class ComicModel(
    val id: Int,
    val title: String,
    val description: String,
    val creators: List<ComicCreatorModel>,
    val characters: List<ComicCharacterModel>,
    val imageExt: String,
    val ImagePath: String
)
