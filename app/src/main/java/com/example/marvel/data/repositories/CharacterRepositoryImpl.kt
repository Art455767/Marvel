package com.example.marvel.data.repositories

import com.example.marvel.data.api.MarvelApi
import com.example.marvel.data.models.CharacterResponse
import com.example.marvel.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val api: MarvelApi) : CharacterRepository {
    override suspend fun getCharacters(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Flow<CharacterResponse> {
        return flow {
            val response = api.getCharacters(ts, publicKey, hash, offset, limit)
            emit(response)
        }
    }
}