package com.example.marvel.data.repositories

import com.example.marvel.data.api.MarvelApi
import com.example.marvel.data.api.RetrofitInstance
import com.example.marvel.data.models.CharacterResponse
import com.example.marvel.domain.repositories.CharacterRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

open class CharacterRepository @Inject constructor(private val api: MarvelApi) : CharacterRepository() {
    suspend fun getCharacters(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Flow<CharacterResponse> {
        return flow {
            val response = api.getCharacters(ts, publicKey, hash, offset, limit)
            emit(response)
        }
    }
}