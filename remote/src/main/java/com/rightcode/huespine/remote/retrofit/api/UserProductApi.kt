package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.request.CommentRequest
import com.rightcode.huespine.remote.model.request.UserProductRequest
import com.rightcode.huespine.remote.model.response.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

internal interface UserProductApi {
    @POST("userProducts")
    fun postUserProduct(
        @Body body: UserProductRequest
    ): Completable

    @GET("userProducts")
    fun getUserProducts(
        @Query("filter") filter: Array<String>?,
        @Query("search") search: String?,
        @Query("sort") sort: String?,
        @Query("order") order: String?,
        @Query("maxPrice") maxPrice: Int?,
        @Query("minPrice") minPrice: Int?,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int,
        @Query("userId") userId: Long?
    ): Single<GetUserProductListResponse>

    @GET("userProducts/{id}")
    fun getUserProduct(
        @Path("id") id: Long
    ): Single<GetUserProductResponse>

    @PUT("userProducts/{id}")
    fun putUserProductId(
        @Path("id") id: Long,
        @Body body: UserProductRequest
    ): Completable

    @DELETE("userProducts/{id}")
    fun deleteUserProduct(
        @Path("id") id: Long
    ): Completable

    @GET("userProducts/{id}/like")
    fun getProductIdLike(
        @Path("id") id: Long
    ): Single<List<GetPostIdLike>>


    @GET("userProducts/{id}/comments")
    fun getUserProductComments(
        @Path("id") id: Long,
        @Query("sort") sort: String?,
        @Query("order") order: String?,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetUserProductCommentListResponse>

    @POST("userProducts/{id}/comments")
    fun postUserProductComment(
        @Path("id") id: Long,
        @Body body: CommentRequest
    ): Completable

    @FormUrlEncoded
    @POST("userProducts/{id}/like")
    fun postProductIdLiked(
        @Path("id") id: Long,
        @Field("liked") isLike: Boolean
    ): Completable

    @FormUrlEncoded
    @POST("userProducts/comments/{id}/like")
    fun postProductCommentLike(
        @Path("id") id: Long,
        @Field("liked") isLike: Boolean
    ): Completable

    @PUT("userProducts/comments/{id}")
    fun putProductComment(
        @Path("id") id: Long,
        @Body body: CommentRequest
    ): Completable

    @DELETE("userProducts/comments/{id}")
    fun deleteProductComment(
        @Path("id") id: Long
    ): Completable

    @GET("userProducts/{id}/like")
    fun getUserProductLikeList(
        @Path("id") id: Long
    ): Single<List<GetUserProductLikeListResponse>>

    @POST("userProducts/{id}/shared")
    fun postUserProductIdShared(
        @Path("id") id: Long
    ): Completable

}