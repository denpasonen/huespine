package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.UserData
import com.rightcode.huespine.domain.model.User

internal object UserMapper : Mapper<UserData, User> {
    override fun mapToDomain(from: UserData): User {
        return User(
            id = from.id,
            name = from.name,
            email = from.email,
            createdAt = from.createdAt,
            profileId = from.profileId,
            profileName = from.profileName,
            profileImage = from.profileImage
        )
    }
}