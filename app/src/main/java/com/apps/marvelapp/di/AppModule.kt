package com.apps.marvelapp.di

import android.content.Context
import androidx.room.Room
import com.apps.marvelapp.data.local.AppDataBase
import com.apps.marvelapp.data.local.CharactersDao
import com.apps.marvelapp.domain.repository.CharactersRepository
import com.apps.marvelapp.domain.usecase.AddCharacterToFavoritesUseCase
import com.apps.marvelapp.domain.usecase.GetCharactersListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideCharacterDao(appDataBase: AppDataBase) : CharactersDao {
        return appDataBase.charactersDao()
    }

    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context) : AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "marvel_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideHeroesUseCase(
        charactersRepository: CharactersRepository
    ) : GetCharactersListUseCase {
        return GetCharactersListUseCase(charactersRepository)
    }

    @Singleton
    @Provides
    fun provideAddCharacterToFavoritesUseCase(
        charactersRepository: CharactersRepository
    ) : AddCharacterToFavoritesUseCase {
        return AddCharacterToFavoritesUseCase(charactersRepository)
    }
}