package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.request.Order
import com.rightcode.huespine.remote.model.request.Sort
import com.rightcode.huespine.remote.model.response.GetProductListResponse
import com.rightcode.huespine.remote.model.response.GetProductResponse
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

internal interface ProductApi {

    @GET("products")
    fun getProducts(
        @Query("mallId") mallId: Long?,
        @Query("search") search: String?,
        @Query("categoryId") categoryId: Int?,
        @Query("filter") filter: String?,
        @Query("sort") sort: Sort,
        @Query("minimumPrice") minimumPrice: Long?,
        @Query("maximumPrice") maximumPrice: Long?,
        @Query("order") order: Order,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetProductListResponse>

    @GET("products/{id}")
    fun getProducts(
        @Path("id") id: Long
    ): Single<GetProductResponse>

    @FormUrlEncoded
    @POST("products/{id}/liked")
    fun postProductIdLiked(
        @Path("id") id: Long,
        @Field("liked") isLike: Boolean
    ): Completable

    @POST("keywordLogs")
    fun postKeywordLog(
        @Body requestBody: RequestBody
    ): Completable
}