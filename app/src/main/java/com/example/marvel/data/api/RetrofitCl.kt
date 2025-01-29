package com.example.marvel.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val marvelApi: MarvelApi = retrofit.create(MarvelApi::class.java)