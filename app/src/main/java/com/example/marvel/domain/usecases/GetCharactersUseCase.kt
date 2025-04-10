package com.example.marvel.domain.usecases

import com.example.marvel.data.models.CharacterResponse
import com.example.marvel.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {
    suspend fun execute(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Flow<CharacterResponse> {
        return repository.getCharacters(ts, publicKey, hash, offset, limit)
    }
}
