package com.domain.repositories

import com.domain.models.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(
        ts: String,
        publicKey: String,
        hash: String,
        offset: Int,
        limit: Int,
    ): Flow<CharacterResponse>
}