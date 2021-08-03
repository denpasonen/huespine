package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.UserData
import com.rightcode.huespine.remote.model.response.AuthResponse

internal object AuthResponseMapper : Mapper<AuthResponse, UserData> {
    override fun mapToData(from: AuthResponse): UserData {
        return UserData(
            id = from.id,
            name = from.name,
            email = from.email,
            createdAt = from.createdAt,
            profileId = from.profile.id,
            profileName = from.profile.name,
            profileImage = from.profile.image
        )
    }
}