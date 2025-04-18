package com.example.data.mappers

import com.domain.models.Character
import com.domain.models.CharacterData
import com.domain.models.CharacterResponse
import com.domain.models.Thumbnail
import com.example.data.models.DataCharacter
import com.example.data.models.DataCharacterData
import com.example.data.models.DataCharacterResponse
import com.example.data.models.DataThumbnail

fun DataCharacterResponse.toDomain(): CharacterResponse {
    return CharacterResponse(
        data = this.data.toDomain()
    )
}

fun DataCharacter.toDomain(): Character {
    return Character(
        name = this.name,
        description = this.description,
        thumbnail = this.thumbnail.toDomain()
    )
}

fun DataCharacterData.toDomain(): CharacterData {
    return CharacterData(
        results = results.map { it.toDomain() }
    )
}

fun DataThumbnail.toDomain(): Thumbnail {
    return Thumbnail(
        path = this.path,
        extension = this.extension
    )
}