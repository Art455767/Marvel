package com.example.marvel.utils

enum class ApiKeys(val key: String) {
    PUBLIC_KEY("bf0b527468ed482a1340992bc7039cf7"),
    PRIVATE_KEY("d31130b3cfa56235a59c7d1e11cf1ff477d332bd");

    companion object {
        fun getPublicKey(): String {
            return PUBLIC_KEY.key
        }

        fun getPrivateKey(): String {
            return PRIVATE_KEY.key
        }
    }
}