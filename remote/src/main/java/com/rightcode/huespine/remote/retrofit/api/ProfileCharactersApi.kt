package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.ProfileCharactersListResponse
import io.reactivex.Single
import retrofit2.http.GET

internal interface ProfileCharactersApi {

    @GET("profileCharacters")
    fun getProfileCharacters(): Single<ProfileCharactersListResponse>
}