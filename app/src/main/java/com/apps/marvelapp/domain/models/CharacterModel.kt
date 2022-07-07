package com.apps.marvelapp.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "characters")
data class CharacterModel(
    @PrimaryKey val id: Int,
    val name: String,
    val bio: String,
    val imageExt: String,
    val imagePath: String
):Parcelable
