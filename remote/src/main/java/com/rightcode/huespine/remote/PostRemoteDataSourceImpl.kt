package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.LikeListData
import com.rightcode.huespine.data.model.LikedUserData
import com.rightcode.huespine.data.model.PostCommentData
import com.rightcode.huespine.data.model.PostData
import com.rightcode.huespine.data.source.remote.PostRemoteDataSource
import com.rightcode.huespine.remote.mapper.*
import com.rightcode.huespine.remote.model.request.CommentRequest
import com.rightcode.huespine.remote.model.request.PostRequest
import com.rightcode.huespine.remote.retrofit.api.PostApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class PostRemoteDataSourceImpl @Inject constructor(
    private val api: PostApi,
    private val gson: Gson
) : PostRemoteDataSource {

    override fun getPostList(
        type: String?,
        start: Int,
        limit: Int
    ): Single<List<PostData>> {
        return api.getPostList(
            type = type,
            search = null,
            filter = null,
            sort = "createdAt",
            order = "DESC",
            start = start,
            perPage = limit,
            userId = null
        ).map(GetPostListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getUserPostList(
        type: String?,
        userId: Long,
        start: Int,
        limit: Int
    ): Single<List<PostData>> {
        return api.getPostList(
            type = type,
            search = null,
            filter = null,
            sort = "createdAt",
            order = "DESC",
            start = start,
            perPage = limit,
            userId = userId
        ).map(GetPostListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getPostListByFilter(
        type: String?,
        search: String,
        sort: String,
        order: String,
        start: Int,
        limit: Int
    ): Single<List<PostData>> {
        return api.getPostList(
            type = type,
            search = search,
            filter = null,
            sort = sort,
            order = order,
            start = start,
            perPage = limit,
            userId = null
        ).map(GetPostListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getMyPostList(
        userId: Long,
        start: Int,
        limit: Int
    ): Single<Pair<List<PostData>, Int>> {
        return api.getPostList(
            type = null,
            search = null,
            filter = null,
            sort = "createdAt",
            order = "DESC",
            start = start,
            perPage = limit,
            userId = userId
        ).map { response ->
            GetPostListMapper.mapToData(response) to response.total
        }.catchRemoteError(gson)
    }

    override fun getPost(id: Long): Single<PostData> {
        return api.getPost(id)
            .map(GetPostMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getPopularityPosts(
        start: Int,
        limit: Int
    ): Single<List<PostData>> {
        return api.getPostList(
            filter = "popularity",
            type = null,
            sort = null,
            order = null,
            userId = null,
            search = null,
            start = start,
            perPage = limit
        ).map(GetPostListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun createPost(type: String, images: List<String>, description: String): Completable {
        return api.postPost(
            PostRequest(
                type, images, description
            )
        ).catchRemoteError(gson)
    }

    override fun updatePostLike(id: Long, isLike: Boolean): Completable {
        return api.postPostIdLiked(
            id, isLike
        ).catchRemoteError(gson)
    }

    override fun updatePost(
        id: Long,
        type: String,
        images: List<String>,
        description: String
    ): Completable {
        return api.putPostId(
            id = id,
            requestBody = PostRequest(
                type = type,
                images = images,
                description = description
            )
        ).catchRemoteError(gson)
    }

    override fun deletePost(id: Long): Completable {
        return api.deletePost(id)
            .catchRemoteError(gson)
    }

    override fun reportPost(id: Long): Completable {
        return api.reportPost(id)
            .catchRemoteError(gson)
    }

    override fun getLikedUsers(id: Long): Single<List<LikedUserData>> {
        return api.getPostIdLike(id)
            .map(GetPostIdLikeMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getPostComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<PostCommentData>> {
        return api.getPostComments(
            id = id,
            start = start,
            perPage = limit,
            sort = "createdAt",
            order = "ASC"
        ).map(GetPostCommentListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun createComment(id: Long, parentId: Long?, content: String): Completable {
        return api.postPostComment(
            id = id,
            body = CommentRequest(parentId, content)
        ).catchRemoteError(gson)
    }

    override fun updateCommentLike(id: Long, isLike: Boolean): Completable {
        return api.postPostCommentLike(id, isLike)
            .catchRemoteError(gson)
    }

    override fun updateComment(id: Long, parentId: Long?, content: String): Completable {
        return api.putPostComment(
            id = id,
            body = CommentRequest(parentId, content)
        ).catchRemoteError(gson)
    }

    override fun deleteComment(id: Long): Completable {
        return api.deletePostComment(id)
            .catchRemoteError(gson)
    }

    override fun reportComment(id: Long): Completable {
        return reportComment(id)
            .catchRemoteError(gson)
    }

    override fun getPostLikeList(id: Long): Single<List<LikeListData>> {
        return api.getPostLikeList(id).map(GetPostLikeListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun postKeywordLogs(keyword: String): Completable {
        return api.postKeywordLog("{\"keyword\":\"$keyword\"}".toRequestBody("application/json".toMediaType()))
            .catchRemoteError(gson)
    }

    override fun addShareCount(id: Long): Completable {
        return api.postPostIdShared(id)
            .catchRemoteError(gson)
    }
}