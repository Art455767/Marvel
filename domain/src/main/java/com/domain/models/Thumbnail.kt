package com.domain.models

data class Thumbnail(val path: String, val extension: String) {
    fun getImageUrl(): String {
        return path
    }

    fun getExtensionValue() = extension
}