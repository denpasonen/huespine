package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.LikeListData
import com.rightcode.huespine.data.model.LikedUserData
import com.rightcode.huespine.data.model.PostCommentData
import com.rightcode.huespine.data.model.PostData
import io.reactivex.Completable
import io.reactivex.Single

interface PostRemoteDataSource {
    fun getPostList(
        type: String?,
        start: Int,
        limit: Int
    ): Single<List<PostData>>

    fun getUserPostList(
        type: String?,
        userId: Long,
        start: Int,
        limit: Int
    ): Single<List<PostData>>

    fun getPostListByFilter(
        type: String?,
        search: String,
        sort: String,
        order: String,
        start: Int,
        limit: Int
    ): Single<List<PostData>>

    fun getMyPostList(
        userId: Long,
        start: Int,
        limit: Int
    ): Single<Pair<List<PostData>, Int>>

    fun getPost(
        id: Long
    ): Single<PostData>

    fun getPopularityPosts(
        start: Int,
        limit: Int
    ): Single<List<PostData>>

    fun createPost(type: String, images: List<String>, description: String): Completable

    fun updatePost(
        id: Long, type: String, images: List<String>, description: String
    ): Completable

    fun deletePost(
        id: Long
    ): Completable

    fun reportPost(
        id: Long
    ): Completable

    fun updatePostLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun getLikedUsers(
        id: Long
    ): Single<List<LikedUserData>>

    fun updateCommentLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun getPostComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<PostCommentData>>

    fun createComment(
        id: Long,
        parentId: Long?,
        content: String
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
    ): Single<List<LikeListData>>

    fun postKeywordLogs(keyword: String): Completable

    fun addShareCount(
        id: Long
    ): Completable
}


