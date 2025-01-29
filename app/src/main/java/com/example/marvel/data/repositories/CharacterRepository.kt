package com.example.marvel.data.repositories

import com.example.marvel.data.api.marvelApi
import com.example.marvel.data.models.CharacterResponse
import com.example.marvel.domain.repositories.ICharacterRepository
import retrofit2.Call

class CharacterRepository : ICharacterRepository {
    override fun getCharacters(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Call<CharacterResponse> {
        return marvelApi.getCharacters(ts, publicKey, hash, offset, limit)
    }
}