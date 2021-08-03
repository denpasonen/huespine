package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.NotificationListMapper
import com.rightcode.huespine.data.source.remote.NotificationRemoteDataSource
import com.rightcode.huespine.domain.model.Notification
import com.rightcode.huespine.domain.repository.NotificationRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class NotificationRepositoryImpl @Inject constructor(
    private val remote: NotificationRemoteDataSource
) : NotificationRepository {
    override fun getNotificationList(
        start: Int,
        perPage: Int
    ): Single<Pair<List<Notification>, Int>> {
        return remote.getNotificationList(start, perPage)
            .map(NotificationListMapper::mapToDomain)
    }

    override fun putNotifications(ids: List<Long>): Completable {
        return remote.putNotifications(ids)
    }

    override fun deleteNotifications(ids: List<Long>): Completable {
        return remote.deleteNotifications(ids)
    }
}