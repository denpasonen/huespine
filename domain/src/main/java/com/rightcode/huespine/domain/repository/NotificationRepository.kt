package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.Notification
import io.reactivex.Completable
import io.reactivex.Single

interface NotificationRepository {

    fun getNotificationList(
        start: Int,
        perPage: Int
    ): Single<Pair<List<Notification>, Int>>

    fun putNotifications(
        ids: List<Long>
    ): Completable

    fun deleteNotifications(
        ids: List<Long>
    ): Completable
}