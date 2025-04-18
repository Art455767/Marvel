package com.domain.usecases

import com.domain.repositories.CharacterRepository
import com.domain.models.CharacterResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {
    suspend fun execute(ts: String, publicKey: String, hash: String, offset: Int, limit: Int): Flow<CharacterResponse> {
        return repository.getCharacters(ts, publicKey, hash, offset, limit)
    }
}
