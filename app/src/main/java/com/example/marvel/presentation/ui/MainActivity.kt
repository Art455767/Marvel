package com.example.marvel.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.presentation.adapters.CharacterAdapter
import com.example.marvel.presentation.viewmodels.CharacterViewModel
import com.example.marvel.utils.generateHash
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var characterAdapter: CharacterAdapter
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        characterAdapter = CharacterAdapter()
        recyclerView.adapter = characterAdapter

        val publicKey = "bf0b527468ed482a1340992bc7039cf7"
        val privateKey = "d31130b3cfa56235a59c7d1e11cf1ff477d332bd"
        val ts = "1"
        val hash = generateHash(ts, privateKey, publicKey)
        val offset = 0
        val limit = 100

        characterViewModel.loadCharacters(ts, publicKey, hash, offset, limit)

        characterViewModel.characters.observe(this) { response ->
            response?.data?.results?.let { characters ->
                characterAdapter.submitList(characters)
            }
        }
    }
}