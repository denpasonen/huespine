package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.GetHomeProductResponse
import io.reactivex.Single
import retrofit2.http.GET

internal interface HomeApi {

    @GET("homes")
    fun getHomes(): Single<GetHomeProductResponse>

}