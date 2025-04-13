package com.example.marvel.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.presentation.adapters.CharacterAdapter
import com.example.marvel.presentation.viewmodel.CharacterViewModel
import com.example.marvel.utils.generateHash
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment(R.layout.fragment_character_list) {

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var adapter: CharacterAdapter
    private var offset = 0
    private val limit = 20

    private val ts = "1"
    private val publicKey = "bf0b527468ed482a1340992bc7039cf7"
    private val privateKey = "d31130b3cfa56235a59c7d1e11cf1ff477d332bd"
    private val hash = generateHash(ts, privateKey, publicKey)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CharacterAdapter()
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.characters.collect { characterResponse ->
                characterResponse?.let {
                    adapter.setCharacters(it.data.results)
                }
            }
        }
        viewModel.fetchCharacters(ts, publicKey, hash, offset, limit)

    }
}