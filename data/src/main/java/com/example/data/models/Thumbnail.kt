package com.example.data.models

data class DataThumbnail(val path: String, val extension: String) {
    fun getImageUrl(): String {
        return path
    }

    fun getExtensionValue() = extension
}
