package com.example.data.di

import com.example.data.api.MarvelApi
import com.example.data.repositories.CharacterRepositoryImpl
import com.domain.repositories.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideCharacterRepository(api: MarvelApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }

    @Provides
    fun provideMarvelApi(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }
}