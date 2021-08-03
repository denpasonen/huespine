package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.CategoryListResponse
import com.rightcode.huespine.remote.model.response.GetUserIdResponse
import com.rightcode.huespine.remote.model.response.ProfileCharactersListResponse
import com.rightcode.huespine.remote.model.response.TastesListResponse
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

internal interface UserApi {

    @GET("categories")
    fun getCategories(): Single<CategoryListResponse>

    @GET("profileCharacters")
    fun getProfileCharacters(): Single<ProfileCharactersListResponse>

    @GET("tastes")
    fun getTastes(): Single<TastesListResponse>

    @GET("users/{id}")
    fun getUserId(
        @Path("id") id: Long
    ): Single<GetUserIdResponse>

    @PUT("users")
    fun putUser(
        @Body requestBody: RequestBody
    ): Completable

    @PUT("users/password")
    fun putUserPassword(
        @Body requestBody: RequestBody
    ): Completable

    @GET("users")
    fun getUser(): Single<GetUserIdResponse>

}