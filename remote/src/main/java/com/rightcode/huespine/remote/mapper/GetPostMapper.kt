package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.PostData
import com.rightcode.huespine.remote.model.response.GetPostResponse
import com.rightcode.huespine.remote.utils.enumValueOrNull

internal object GetPostMapper : Mapper<GetPostResponse, PostData> {
    override fun mapToData(from: GetPostResponse): PostData {
        return PostData(
            id = from.id,
            userId = from.userId,
            type = from.type.enumValueOrNull() ?: PostData.PostType.NONE,
            images = from.images,
            description = from.description,
            status = from.status,
            likedCount = from.likedCount,
            commentCount = from.commentCount,
            createdAt = from.createdAt,
            profileName = from.profileName,
            profileImage = from.profileImage,
            liked = from.liked
        )
    }
}
