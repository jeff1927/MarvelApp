package com.apps.marvelapp.domain.models

data class ComicDataContainerModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ComicModel>,
    val total: Int
)