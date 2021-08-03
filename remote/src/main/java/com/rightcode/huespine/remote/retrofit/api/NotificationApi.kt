package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.request.PutNotificationRequest
import com.rightcode.huespine.remote.model.response.GetNotificationsResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

internal interface NotificationApi {

    @GET("notifications")
    fun getNotificationList(
        @Query("start") start: Int,
        @Query("perPage") perPage: Int
    ): Single<GetNotificationsResponse>

    @PUT("notifications")
    fun putNotifications(
        @Body body: PutNotificationRequest
    ): Completable

    @DELETE("notifications")
    fun deleteNotifications(
        @Query("ids") ids: LongArray
    ): Completable

}