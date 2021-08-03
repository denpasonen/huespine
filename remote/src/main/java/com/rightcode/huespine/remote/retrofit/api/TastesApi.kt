package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.TastesListResponse
import io.reactivex.Single
import retrofit2.http.GET

internal interface TastesApi {

    @GET("tastes")
    fun getTastes(): Single<TastesListResponse>
}