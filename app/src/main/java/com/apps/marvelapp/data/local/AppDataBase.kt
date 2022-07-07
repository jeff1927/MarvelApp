package com.apps.marvelapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps.marvelapp.domain.models.CharacterModel

@Database(entities = [CharacterModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}