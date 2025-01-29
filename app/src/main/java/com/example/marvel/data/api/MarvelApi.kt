package com.example.marvel.data.api

import com.example.marvel.data.models.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("v1/public/characters")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") publicKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Call<CharacterResponse>
}