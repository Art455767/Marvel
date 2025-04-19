package com.example.marvel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecases.GetCharactersUseCase
import com.domain.models.CharacterResponse
import com.example.marvel.utils.generateHash
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    private val _characters = MutableStateFlow<CharacterResponse?>(null)
    val characters: StateFlow<CharacterResponse?> get() = _characters

    fun fetchCharacters(ts: String, publicKey: String, privateKey: String) {
        val hash = generateHash(ts, privateKey, publicKey)
        viewModelScope.launch {
            getCharactersUseCase.execute(ts, publicKey, hash, 0, 10).collect { characterResponse ->
                _characters.value = characterResponse
            }
        }
    }
}