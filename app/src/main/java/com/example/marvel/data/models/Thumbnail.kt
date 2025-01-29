package com.example.marvel.data.models

data class Thumbnail(private val path: String, private val extension: String) {
    fun getImageUrl(): String {
        return path
    }

    fun getExtension() = extension
}