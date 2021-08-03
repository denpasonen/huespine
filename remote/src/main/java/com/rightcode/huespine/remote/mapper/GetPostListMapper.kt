package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.PostData
import com.rightcode.huespine.remote.model.response.GetPostListResponse
import com.rightcode.huespine.remote.utils.enumValueOrNull

internal object GetPostListMapper : Mapper<GetPostListResponse, List<PostData>> {
    override fun mapToData(from: GetPostListResponse): List<PostData> {
        return from.data.map { data ->
            PostData(
                id = data.id,
                userId = data.userId,
                type = data.type.enumValueOrNull() ?: PostData.PostType.NONE,
                images = data.images,
                description = data.description,
                status = data.status,
                likedCount = data.likedCount,
                commentCount = data.commentCount,
                createdAt = data.createdAt,
                profileName = data.profileName,
                profileImage = data.profileImage,
                liked = data.liked
            )
        }
    }
}