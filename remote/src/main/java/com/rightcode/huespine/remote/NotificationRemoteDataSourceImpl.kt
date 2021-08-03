package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.NotificationData
import com.rightcode.huespine.data.source.remote.NotificationRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetNotificationListMapper
import com.rightcode.huespine.remote.model.request.PutNotificationRequest
import com.rightcode.huespine.remote.retrofit.api.NotificationApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class NotificationRemoteDataSourceImpl @Inject constructor(
    private val api: NotificationApi,
    private val gson: Gson
) : NotificationRemoteDataSource {
    override fun getNotificationList(
        start: Int,
        perPage: Int
    ): Single<Pair<List<NotificationData>, Int>> {
        return api.getNotificationList(start, perPage)
            .map(GetNotificationListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun putNotifications(ids: List<Long>): Completable {
        return api.putNotifications(
            PutNotificationRequest(ids)
        ).catchRemoteError(gson)
    }

    override fun deleteNotifications(ids: List<Long>): Completable {
        return api.deleteNotifications(ids.toLongArray())
            .catchRemoteError(gson)
    }
}