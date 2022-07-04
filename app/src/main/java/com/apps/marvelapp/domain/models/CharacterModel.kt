package com.apps.marvelapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterModel(
    val id: Int,
    val name: String,
    val bio: String,
    val imageExt: String,
    val imagePath: String
):Parcelable
