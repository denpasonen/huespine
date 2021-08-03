package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.LikeList
import com.rightcode.huespine.domain.model.LikedUser
import com.rightcode.huespine.domain.model.Post
import com.rightcode.huespine.domain.model.PostComment
import io.reactivex.Completable
import io.reactivex.Single

interface PostRepository {
    fun getPostList(
        type: String?,
        start: Int,
        limit: Int
    ): Single<List<Post>>

    fun getUserPostList(
        type: String?,
        userId: Long,
        start: Int,
        limit: Int
    ): Single<List<Post>>

    fun getPostListByFilter(
        type: String?,
        search: String,
        sort: String,
        order: String,
        start: Int,
        limit: Int
    ): Single<List<Post>>

    fun getMyPostList(
        userId: Long,
        start: Int,
        limit: Int
    ): Single<Pair<List<Post>, Int>>

    fun getPost(id: Long): Single<Post>

    fun getPopularityPosts(
        start: Int,
        limit: Int
    ): Single<List<Post>>

    fun createPost(
        type: String, images: List<String>, description: String
    ): Completable

    fun updatePostLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun updatePost(
        id: Long, type: String, images: List<String>, description: String
    ): Completable

    fun deletePost(
        id: Long
    ): Completable

    fun reportPost(
        id: Long
    ): Completable

    fun getLikedUsers(
        id: Long
    ): Single<List<LikedUser>>


    fun getPostComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<PostComment>>

    fun createComment(
        id: Long,
        parentId: Long?,
        content: String
    ): Completable

    fun updateCommentLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun updateComment(
        id: Long,
        parentId: Long?,
        content: String
    ): Completable

    fun deleteComment(
        id: Long
    ): Completable

    fun reportComment(
        id: Long
    ): Completable

    fun getPostLikeList(
        id: Long
    ): Single<List<LikeList>>

    fun getSearchList(): Single<Set<String>>

    fun addShareCount(
        id: Long
    ): Completable
}