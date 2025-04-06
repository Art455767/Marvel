package com.example.marvel.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.data.models.CharacterResponse
import com.example.marvel.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {
    private val _characters = MutableStateFlow<CharacterResponse?>(null)
    val characters: StateFlow<CharacterResponse?> get() = _characters

    fun loadCharacters(ts: String, publicKey: String, hash: String, offset: Int, limit: Int) {
        viewModelScope.launch {
            getCharactersUseCase.execute(ts, publicKey, hash, offset, limit).collect { response ->
                _characters.value = response
            }
        }
    }
}