package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.request.Order
import com.rightcode.huespine.remote.model.request.Sort
import com.rightcode.huespine.remote.model.response.GetMallListResponse
import com.rightcode.huespine.remote.model.response.GetMallProductListResponse
import com.rightcode.huespine.remote.model.response.GetMallResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

internal interface MallApi {

    @GET("malls")
    fun getMalls(
        @Query("filter") filter: String?,
        @Query("search") search: String?,
        @Query("sort") sort: Sort,
        @Query("order") order: Order,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetMallListResponse>


    @GET("malls/{id}")
    fun getMallsId(
        @Path("id") id: Long,
    ): Single<GetMallResponse>

    @GET("malls/{id}/product")
    fun getMallsIdProduct(
        @Path("id") id: Long,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetMallProductListResponse>

    @GET("malls/rank/filter")
    fun getMallsRankFilter(
        @Query("typeIds") typeIds: Array<Long>?,
        @Query("hashtagIds") hashtagIds: Array<Long>?,
    ): Single<GetMallListResponse>

    @FormUrlEncoded
    @POST("malls/{id}/like")
    fun postMallIdLiked(
        @Path("id") id: Long,
        @Field("liked") isLike: Boolean
    ): Completable

}