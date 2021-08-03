package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.PostData
import com.rightcode.huespine.domain.model.Post


internal object PostListMapper : Mapper<List<PostData>, List<Post>> {
    override fun mapToDomain(from: List<PostData>): List<Post> {
        return from.map { post ->
            Post(
                id = post.id,
                userId = post.userId,
                type = when (post.type) {
                    PostData.PostType.TALK -> Post.PostType.TALK
                    PostData.PostType.QUESTION -> Post.PostType.QUESTION
                    PostData.PostType.BUY -> Post.PostType.BOUGHT
                    PostData.PostType.DESIGNED -> Post.PostType.DESIGNED
                    PostData.PostType.NONE -> Post.PostType.NONE
                },
                images = post.images,
                description = post.description,
                status = post.status,
                likedCount = post.likedCount,
                commentCount = post.commentCount,
                createdAt = post.createdAt,
                profileName = post.profileName,
                profileImage = post.profileImage,
                liked = post.liked
            )
        }
    }
}