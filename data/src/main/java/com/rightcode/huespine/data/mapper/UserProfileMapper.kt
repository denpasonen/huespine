package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.UserProfileData
import com.rightcode.huespine.domain.model.UserProfile

internal object UserProfileMapper : Mapper<UserProfileData, UserProfile> {
    override fun mapToDomain(from: UserProfileData): UserProfile {
        return UserProfile(
            id = from.id,
            name = from.name,
            email = from.email,
            createdAt = from.createdAt,
            profileId = from.profileId,
            profileName = from.profileName,
            profileImage = from.profileImage,
            likeCount = from.likeCount,
            postCount = from.postCount,
            level = from.level,
            tastes = from.tastes,
            category = from.category
        )
    }
}