package com.example.marvel.presentation.di

import com.example.marvel.domain.repositories.CharacterRepositoryImpl
import com.example.marvel.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideGetCharactersUseCase(repository: CharacterRepositoryImpl): GetCharactersUseCase {
        return GetCharactersUseCase(repository)
    }
}