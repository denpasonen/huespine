package com.rightcode.huespine.remote.retrofit.api

import io.reactivex.Completable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Url

interface UploadApi {
    @PUT
    fun putFile(
        @Url
        url: String,
        @Body
        requestBody: RequestBody
    ): Completable
}