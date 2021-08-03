package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.GetHashtagListResponse
import com.rightcode.huespine.remote.model.response.GetHashtagResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface HashtagApi {

    @GET("hashtags")
    fun getHashtags(
        @Query("search") search: String?,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetHashtagListResponse>

    @GET("hashtags/{id}")
    fun getHashtag(
        @Path("id") id: Long
    ): Single<GetHashtagResponse>

}