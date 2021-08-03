package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.LikedUserData
import com.rightcode.huespine.remote.model.response.GetPostIdLike

internal object GetPostIdLikeMapper : Mapper<List<GetPostIdLike>, List<LikedUserData>> {
    override fun mapToData(from: List<GetPostIdLike>): List<LikedUserData> {
        return from.map { data ->
            LikedUserData(
                id = data.id,
                profileName = data.profileName,
                image = data.image,
                name = data.name
            )
        }
    }
}