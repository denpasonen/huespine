package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.PostData
import com.rightcode.huespine.domain.model.Post


internal object PostMapper : Mapper<PostData, Post> {
    override fun mapToDomain(from: PostData): Post {
        return Post(
            id = from.id,
            userId = from.userId,
            type = when (from.type) {
                PostData.PostType.TALK -> Post.PostType.TALK
                PostData.PostType.QUESTION -> Post.PostType.QUESTION
                PostData.PostType.BUY -> Post.PostType.BOUGHT
                PostData.PostType.DESIGNED -> Post.PostType.DESIGNED
                PostData.PostType.NONE -> Post.PostType.NONE
            },
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
