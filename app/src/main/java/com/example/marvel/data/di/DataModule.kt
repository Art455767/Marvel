package com.example.marvel.data.di

import com.example.marvel.data.api.MarvelApi
import com.example.marvel.data.repositories.CharacterRepository
import com.example.marvel.domain.repositories.CharacterRepository as DomainCharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideCharacterRepository(api: MarvelApi): DomainCharacterRepository {
        return CharacterRepository(api)
    }

    @Provides
    fun provideMarvelApi(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }
}