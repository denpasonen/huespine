package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.NotificationData
import io.reactivex.Completable
import io.reactivex.Single

interface NotificationRemoteDataSource {
    fun getNotificationList(
        start: Int,
        perPage: Int
    ): Single<Pair<List<NotificationData>, Int>>

    fun putNotifications(
        ids: List<Long>
    ): Completable

    fun deleteNotifications(
        ids: List<Long>
    ): Completable
}