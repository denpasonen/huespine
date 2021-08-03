package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.UserProductCommentData
import com.rightcode.huespine.remote.model.response.GetUserProductCommentListResponse
import com.rightcode.huespine.remote.utils.enumValueOrNull

internal object GetUserProductCommentListMapper :
    Mapper<GetUserProductCommentListResponse, List<UserProductCommentData>> {
    override fun mapToData(from: GetUserProductCommentListResponse): List<UserProductCommentData> {
        return from.data.map { data ->
            UserProductCommentData(
                id = data.id,
                userId = data.userId,
                status = data.status.enumValueOrNull() ?: UserProductCommentData.Status.NONE,
                likedCount = data.likedCount,
                createdAt = data.createdAt,
                liked = data.liked == true,
                productId = data.productId,
                parentId = data.parentId,
                content = data.content,
                profileImage = data.profileImage,
                profileName = data.profileName
            )
        }
    }
}