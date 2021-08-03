package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Notification
import com.rightcode.huespine.domain.repository.NotificationRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class NotificationServiceImpl @Inject constructor(
    private val repository: NotificationRepository
) : NotificationService {
    override fun getNotificationList(
        start: Int,
        perPage: Int
    ): Single<Pair<List<Notification>, Int>> {
        return repository.getNotificationList(start, perPage)
    }

    override fun putNotifications(ids: List<Long>): Completable {
        return repository.putNotifications(ids)
    }

    override fun deleteNotifications(ids: List<Long>): Completable {
        return repository.deleteNotifications(ids)
    }
}