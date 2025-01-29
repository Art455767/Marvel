package com.example.marvel.utils

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

fun generateHash(ts: String, privateKey: String, publicKey: String): String {
    val md = MessageDigest.getInstance("MD5")
    val hashInBytes = md.digest((ts + privateKey + publicKey).toByteArray(StandardCharsets.UTF_8))
    val sb = StringBuilder()
    for (b in hashInBytes) {
        sb.append(String.format("%02x", b))
    }
    return sb.toString()
}
