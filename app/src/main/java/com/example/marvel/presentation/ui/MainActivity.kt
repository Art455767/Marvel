package com.example.marvel.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.data.models.Character
import com.example.marvel.data.models.CharacterResponse
import com.example.marvel.data.repositories.CharacterRepository
import com.example.marvel.domain.repositories.ICharacterRepository
import com.example.marvel.domain.usecases.GetCharactersUseCase
import com.example.marvel.presentation.adapters.CharacterAdapter
import com.example.marvel.utils.generateHash
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var getCharactersUseCase: GetCharactersUseCase

    private val charactersList = mutableListOf<Character>()
    private val publicKey = "bf0b527468ed482a1340992bc7039cf7"
    private val privateKey = "d31130b3cfa56235a59c7d1e11cf1ff477d332bd"
    private val ts = "1"
    private val offset = 0
    private val limit = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val characterRepository: ICharacterRepository = CharacterRepository()
        getCharactersUseCase = GetCharactersUseCase(characterRepository)

        val hash = generateHash(ts, privateKey, publicKey)
        getCharacters(ts, publicKey, hash, offset, limit)
    }

    private fun getCharacters(ts: String, publicKey: String, hash: String, offset: Int, limit: Int) {
        val call = getCharactersUseCase.execute(ts, publicKey, hash, offset, limit)

        call.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if (response.isSuccessful) {
                    response.body()?.data?.results?.let { characters ->
                        charactersList.addAll(characters)
                        characterAdapter = CharacterAdapter(charactersList)
                        recyclerView.adapter = characterAdapter
                    }
                } else {
                    Log.e("MainActivity", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })
    }
}