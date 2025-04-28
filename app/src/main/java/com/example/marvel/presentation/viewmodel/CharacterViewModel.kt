package com.example.marvel.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.models.CharacterResponse
import com.domain.usecases.GetCharactersUseCase
import com.example.marvel.presentation.MyApplication
import com.example.marvel.utils.ApiKeys
import com.example.marvel.utils.generateHash
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException // Импортируйте HttpException из Retrofit
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    private val _characters = MutableStateFlow<CharacterResponse?>(null)
    val characters: StateFlow<CharacterResponse?> get() = _characters

    fun loadCharacters() {
        val ts = "1"
        val publicKey = ApiKeys.getPublicKey()
        val privateKey = ApiKeys.getPrivateKey()

        val hash = generateHash(ts, privateKey, publicKey)
        viewModelScope.launch {
            try {
                getCharactersUseCase.execute(ts, publicKey, hash, 0, 10).collect { characterResponse ->
                    _characters.value = characterResponse
                }
            } catch (exception: Exception) {
                if (exception is HttpException && exception.code() == 401) { // Используйте метод code()
                    sessionExpired(MyApplication.getApplication())
                } else {
                    // Обработка других ошибок
                    Log.e("CharacterViewModel", "Error loading characters: ${exception.message}")
                }
            }
        }
    }


    private fun sessionExpired(application: Unit) {
        // Логика обработки истечения сессии, например, перенаправление на экран входа
    }

}