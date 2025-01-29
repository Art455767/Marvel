package com.example.marvel.domain.repositories

import com.example.marvel.data.models.CharacterResponse
import retrofit2.Call

interface ICharacterRepository {
    fun getCharacters(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Call<CharacterResponse>
}