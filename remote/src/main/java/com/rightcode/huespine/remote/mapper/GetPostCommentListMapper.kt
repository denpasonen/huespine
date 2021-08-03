package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.PostCommentData
import com.rightcode.huespine.remote.model.response.GetPostCommentListResponse
import com.rightcode.huespine.remote.utils.enumValueOrNull

internal object GetPostCommentListMapper :
    Mapper<GetPostCommentListResponse, List<PostCommentData>> {
    override fun mapToData(from: GetPostCommentListResponse): List<PostCommentData> {
        return from.data.map { data ->
            PostCommentData(
                id = data.id,
                userId = data.userId,
                status = data.status.enumValueOrNull() ?: PostCommentData.Status.NONE,
                likedCount = data.likedCount,
                createdAt = data.createdAt,
                liked = data.liked == true,
                postId = data.postId,
                parentId = data.parentId,
                content = data.content,
                profileImage = data.profileImage,
                profileName = data.profileName
            )
        }
    }
}