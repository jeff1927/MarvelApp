package com.apps.marvelapp.di

import com.apps.marvelapp.data.local.CharactersDao
import com.apps.marvelapp.data.network.MarvelApi
import com.apps.marvelapp.data.network.datasource.ComicsDataSource
import com.apps.marvelapp.data.network.datasource.ComicsDataSourceImpl
import com.apps.marvelapp.data.network.datasource.HeroesDataSource
import com.apps.marvelapp.data.network.datasource.HeroesDataSourceImpl
import com.apps.marvelapp.data.repositoryimpl.ComicsRepositoryImpl
import com.apps.marvelapp.data.repositoryimpl.CharactersRepositoryImpl
import com.apps.marvelapp.domain.constants.BASE_URL
import com.apps.marvelapp.domain.repository.ComicsRepository
import com.apps.marvelapp.domain.repository.CharactersRepository
import com.apps.marvelapp.domain.usecase.GetComicsUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideBaseUrl() : String {
        return BASE_URL
    }

    @Singleton
    @Provides
    fun provideGsonBuilder() : Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideConvertFactory(gson: Gson) : Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor() : HttpLoggingInterceptor{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    @Singleton
    @Provides
    fun provideClient(logging: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory,
        client: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideMarvelApiService(retrofit:Retrofit) : MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }

    @Singleton
    @Provides
    fun provideHeroesDataSource(apiService: MarvelApi) : HeroesDataSource {
        return HeroesDataSourceImpl(apiService)
    }


    @Singleton
    @Provides
    fun provideHeroesRepository(
        heroesDataSource: HeroesDataSource,
        charactersDao: CharactersDao
    ) : CharactersRepository {
        return CharactersRepositoryImpl(heroesDataSource,charactersDao)
    }

    @Singleton
    @Provides
    fun provideComicsDataSource(apiService: MarvelApi) : ComicsDataSource {
        return ComicsDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideComicRepository(comicsDataSource:ComicsDataSource) : ComicsRepository {
        return ComicsRepositoryImpl(comicsDataSource)
    }

    @Singleton
    @Provides
    fun provideComicsUseCase(comicsRepository: ComicsRepository) : GetComicsUseCase {
        return GetComicsUseCase(comicsRepository)
    }
}