package com.example.marvel.domain.usecases

import com.example.marvel.data.models.CharacterResponse
import com.example.marvel.domain.repositories.ICharacterRepository
import retrofit2.Call

class GetCharactersUseCase(private val repository: ICharacterRepository) {
    fun execute(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Call<CharacterResponse> {
        return repository.getCharacters(ts, publicKey, hash, offset, limit)
    }
}
