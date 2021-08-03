package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.request.CommentRequest
import com.rightcode.huespine.remote.model.request.PostRequest
import com.rightcode.huespine.remote.model.response.*
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

internal interface PostApi {
    @GET("posts")
    fun getPostList(
        @Query("type") type: String?,
        @Query("filter") filter: String?,
        @Query("userId") userId: Long?,
        @Query("search") search: String?,
        @Query("sort") sort: String?,
        @Query("order") order: String?,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetPostListResponse>

    @GET("posts/{id}")
    fun getPost(
        @Path("id") id: Long
    ): Single<GetPostResponse>

    @POST("posts")
    fun postPost(
        @Body requestBody: PostRequest
    ): Completable

    @FormUrlEncoded
    @POST("posts/{id}/like")
    fun postPostIdLiked(
        @Path("id") id: Long,
        @Field("liked") isLike: Boolean
    ): Completable

    @PUT("posts/{id}")
    fun putPostId(
        @Path("id") id: Long,
        @Body requestBody: PostRequest
    ): Completable

    @DELETE("posts/{id}")
    fun deletePost(
        @Path("id") id: Long
    ): Completable

    @GET("posts/{id}/like")
    fun getPostIdLike(
        @Path("id") id: Long
    ): Single<List<GetPostIdLike>>

    @POST("posts/{id}/report")
    fun reportPost(
        @Path("id") id: Long
    ): Completable

    @GET("posts/{id}/comments")
    fun getPostComments(
        @Path("id") id: Long,
        @Query("sort") sort: String?,
        @Query("order") order: String?,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetPostCommentListResponse>

    @POST("posts/{id}/comments")
    fun postPostComment(
        @Path("id") id: Long,
        @Body body: CommentRequest
    ): Completable

    @FormUrlEncoded
    @POST("posts/comments/{id}/like")
    fun postPostCommentLike(
        @Path("id") id: Long,
        @Field("liked") isLike: Boolean
    ): Completable

    @PUT("posts/comments/{id}")
    fun putPostComment(
        @Path("id") id: Long,
        @Body body: CommentRequest
    ): Completable

    @DELETE("posts/comments/{id}")
    fun deletePostComment(
        @Path("id") id: Long
    ): Completable

    @POST("posts/comments/{id}/report")
    fun postPostCommentReport(
        @Path("id") id: Long
    ): Completable

    @GET("posts/{id}/like")
    fun getPostLikeList(
        @Path("id") id: Long
    ): Single<List<GetPostLikeListResponse>>

    @POST("keywordLogs")
    fun postKeywordLog(
        @Body requestBody: RequestBody
    ): Completable

    @POST("posts/{id}/shared")
    fun postPostIdShared(
        @Path("id") id: Long
    ): Completable

}
