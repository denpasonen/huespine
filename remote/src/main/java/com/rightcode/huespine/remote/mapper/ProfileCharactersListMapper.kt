package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.ProfileCharactersData
import com.rightcode.huespine.remote.model.response.ProfileCharactersListResponse

internal object ProfileCharactersListMapper : Mapper<ProfileCharactersListResponse, List<ProfileCharactersData>> {
    override fun mapToData(from: ProfileCharactersListResponse): List<ProfileCharactersData> {
        return from.data.map { profileCharacters ->
            ProfileCharactersData(
                id = profileCharacters.id,
                name = profileCharacters.name,
                image = profileCharacters.image,
                order = profileCharacters.order,
            )
        }
    }
}