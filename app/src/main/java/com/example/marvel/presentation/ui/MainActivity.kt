package com.example.marvel.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvel.R
import com.example.marvel.presentation.fragment.CharacterListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CharacterListFragment())
                .commit()
        }
    }
}