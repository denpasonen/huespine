package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.ContactsResponse
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST


internal interface ContactsApi {

    @POST("contacts")
    fun postAuth(
        @Body requestBody: RequestBody
    ): Single<ContactsResponse>

}