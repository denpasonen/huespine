package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.UserData
import com.rightcode.huespine.remote.model.response.AuthSocialResponse

internal object AuthSocialResponseMapper : Mapper<AuthSocialResponse, UserData> {
    override fun mapToData(from: AuthSocialResponse): UserData {
        return UserData(
            id = from.user.id,
            name = from.user.name,
            email = from.user.email,
            createdAt = from.user.createdAt,
            profileId = from.user.profile.id,
            profileName = from.user.profile.name,
            profileImage = from.user.profile.image
        )
    }
}