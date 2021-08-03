package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.PostCommentData
import com.rightcode.huespine.domain.model.PostComment

internal object PostCommentListMapper :
    Mapper<List<PostCommentData>, List<PostComment>> {
    override fun mapToDomain(from: List<PostCommentData>): List<PostComment> {
        return from.map { post ->
            PostComment(
                id = post.id,
                postId = post.postId,
                parentId = post.parentId,
                userId = post.userId,
                status = when (post.status) {
                    PostCommentData.Status.SHOW -> PostComment.Status.SHOW
                    PostCommentData.Status.BLOCKED -> PostComment.Status.BLOCKED
                    PostCommentData.Status.NONE -> PostComment.Status.NONE
                },
                content = post.content,
                likedCount = post.likedCount,
                createdAt = post.createdAt,
                liked = post.liked,
                profileName = post.profileName,
                profileImage = post.profileImage,
                isMine = false
            )
        }
    }
}