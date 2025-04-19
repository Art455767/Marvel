package com.example.data.repositories

import com.example.data.api.MarvelApi
import com.example.data.models.DataCharacterResponse
import com.domain.models.CharacterResponse
import com.domain.repositories.CharacterRepository
import com.example.data.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val api: MarvelApi) : CharacterRepository {
    override suspend fun getCharacters(
        ts: String,
        publicKey: String,
        hash: String,
        offset: Int,
        limit: Int,
    ): Flow<CharacterResponse> {
        return flow {
            val response: DataCharacterResponse = api.getCharacters(ts, publicKey, hash, offset, limit)
            emit(response.toDomain())
        }
    }
}