package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.GetKeywordListResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

internal interface KeywordApi {

    @GET("keywords")
    fun getKeywords(
    ): Single<GetKeywordListResponse>

    @POST("keywordsLogs")
    fun postKeywordLog(
        @Field("keyword") keyword: String
    ): Completable

}