package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.*
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

internal interface UserSettingApi {

    @GET("userSettings")
    fun getCategories(): Single<GetUserSettingResponse>

    @PUT("userSettings")
    fun putUser(
        @Body requestBody: RequestBody
    ): Completable
}