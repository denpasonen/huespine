package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.EventResponse
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*


internal interface EventApi {

    @GET("events")
    fun getEvents(
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Single<List<EventResponse>>

    @POST("users/events")
    fun postEvent(
        @Body requestBody: RequestBody
    ): Completable

    @DELETE("users/events/{id}")
    fun deleteEvent(
        @Path("id") id: Long
    ): Completable

    @GET("events/{id}")
    fun getEvent(
        @Path("id") id: Long
    ): Single<EventResponse>

}