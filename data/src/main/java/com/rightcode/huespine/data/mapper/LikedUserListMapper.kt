package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.LikedUserData
import com.rightcode.huespine.domain.model.LikedUser


internal object LikedUserListMapper : Mapper<List<LikedUserData>, List<LikedUser>> {
    override fun mapToDomain(from: List<LikedUserData>): List<LikedUser> {
        return from.map { post ->
            LikedUser(
                id = post.id,
                profileName = post.profileName,
                image = post.image,
                name = post.name
            )
        }
    }
}