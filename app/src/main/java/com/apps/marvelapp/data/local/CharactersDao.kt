package com.apps.marvelapp.data.local

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apps.marvelapp.domain.models.CharacterModel

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(character: CharacterModel): Long

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<CharacterModel>
}