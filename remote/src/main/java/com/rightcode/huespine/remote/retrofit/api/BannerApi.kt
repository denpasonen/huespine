package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.GetBannerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface BannerApi {

    @GET("banners")
    fun getBanners(
        @Query("type") type: String
    ): Single<List<GetBannerResponse>>

}