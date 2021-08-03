package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.UserProfileData
import com.rightcode.huespine.remote.model.response.GetUserIdResponse

internal object GetUserProfileMapper :
    Mapper<GetUserIdResponse, UserProfileData> {
    override fun mapToData(from: GetUserIdResponse): UserProfileData {

        return UserProfileData(
            id = from.id,
            name = from.name,
            email = from.email,
            createdAt = from.createdAt,
            profileId = from.profile.id,
            profileName = from.profile.name,
            profileImage = from.profile.image,
            level = from.level,
            likeCount = from.likeCount,
            postCount = from.postCount,
            tastes = from.tastes,
            category = from.category
        )
    }
}