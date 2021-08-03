package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.UserProductCommentData
import com.rightcode.huespine.domain.model.UserProductComment

internal object UserProductCommentListMapper :
    Mapper<List<UserProductCommentData>, List<UserProductComment>> {
    override fun mapToDomain(from: List<UserProductCommentData>): List<UserProductComment> {
        return from.map { product ->
            UserProductComment(
                id = product.id,
                productId = product.productId,
                parentId = product.parentId,
                userId = product.userId,
                status = when (product.status) {
                    UserProductCommentData.Status.SHOW -> UserProductComment.Status.SHOW
                    UserProductCommentData.Status.BLOCKED -> UserProductComment.Status.BLOCKED
                    UserProductCommentData.Status.NONE -> UserProductComment.Status.NONE
                },
                content = product.content,
                likedCount = product.likedCount,
                createdAt = product.createdAt,
                profileName = product.profileName,
                profileImage = product.profileImage,
                liked = product.liked,
                isMine = false
            )
        }
    }
}