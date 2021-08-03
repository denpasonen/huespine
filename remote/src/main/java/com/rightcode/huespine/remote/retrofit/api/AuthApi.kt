package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.request.PostAuthSocialRegisterRequest
import com.rightcode.huespine.remote.model.response.AuthResponse
import com.rightcode.huespine.remote.model.response.AuthSocialResponse
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*


internal interface AuthApi {

    @FormUrlEncoded
    @POST("auth/register")
    fun postAuthRegister(
        @Field("type") type: String,
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("profileId") profileId: Int,
        @Field("tasteIds") tasteIds: List<Int>,
        @Field("categoryIds") categoryIds: List<Int>
    ): Single<AuthResponse>

    @FormUrlEncoded
    @POST("auth")
    fun postAuth(
        @Field("email") email: String,
        @Field("password") password: String
    ): Single<AuthResponse>

    @POST("auth/reset")
    fun postAuthReset(
        @Body requestBody: RequestBody
    ): Completable

    @GET("auth/email")
    fun getEmailValid(
        @Query("email") email: String
    ): Completable

    @GET("auth/name")
    fun getNicknameValid(
        @Query("name") name: String
    ): Completable

    @GET("auth")
    fun getAuth(): Completable

    @DELETE("auth/logout")
    fun deleteLogout(
    ): Completable

    @GET("auth/social")
    fun getAuthSocial(
        @Query("type") type: String,
        @Query("platform") platform: String,
        @Query("token") token: String
    ): Single<AuthSocialResponse>

    @POST("auth/social/register")
    fun postAuthSocial(
        @Body body: PostAuthSocialRegisterRequest
    ): Single<AuthResponse>

    @GET("auth/social/token/info")
    fun getAuthSocialTokenInfo(
        @Query("type") type: String,
        @Query("platform") platform: String,
        @Query("token") token: String
    ): Single<Map<String, Any>>

}