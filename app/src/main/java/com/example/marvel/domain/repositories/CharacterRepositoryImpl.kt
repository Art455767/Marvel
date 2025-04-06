package com.example.marvel.domain.repositories

import com.example.marvel.data.models.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface CharacterRepositoryImpl {
    suspend fun getCharacters(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Flow<CharacterResponse>
}