package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.GetMallTypeListResponse
import com.rightcode.huespine.remote.model.response.GetMallTypeResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface MallTypeApi {

    @GET("mallTypes")
    fun getMallTypes(
        @Query("search") search: String?,
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetMallTypeListResponse>

    @GET("mallTypes/{id}")
    fun getMallType(
        @Path("id") id: Long
    ): Single<GetMallTypeResponse>

}