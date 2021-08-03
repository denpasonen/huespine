package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.ProfileCharactersData
import com.rightcode.huespine.domain.model.ProfileCharacters

internal object ProfileCharactersListMapper :
    Mapper<List<ProfileCharactersData>, List<ProfileCharacters>> {
    override fun mapToDomain(from: List<ProfileCharactersData>): List<ProfileCharacters> {
        return from.map { profileCharacters ->
            ProfileCharacters(
                id = profileCharacters.id,
                name = profileCharacters.name,
                image = profileCharacters.image,
                order = profileCharacters.order
            )
        }
    }
}