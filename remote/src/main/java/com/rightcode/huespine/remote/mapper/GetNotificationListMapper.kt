package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.NotificationData
import com.rightcode.huespine.remote.model.response.GetNotificationsResponse
import com.rightcode.huespine.remote.utils.enumValueOrNull

internal object GetNotificationListMapper :
    Mapper<GetNotificationsResponse, Pair<List<NotificationData>, Int>> {
    override fun mapToData(from: GetNotificationsResponse): Pair<List<NotificationData>, Int> {
        return from.data.map { notification ->
            val type = notification.type.enumValueOrNull() ?: NotificationData.Type.NONE

            NotificationData(
                id = notification.id,
                type = type,
                userId = notification.userId,
                description = notification.description,
                info = mapToData(type, notification.info),
                read = notification.read,
                createdAt = notification.createdAt,
                updatedAt = notification.updatedAt,
                title = notification.title
            )
        } to from.total
    }

    private fun mapToData(
        type: NotificationData.Type,
        content: Map<String, Any>?
    ): NotificationData.Info {
        return when (type) {
            NotificationData.Type.NOTICE -> {
                NotificationData.Info.NoticeInfo(
                    noticeId = (content?.get("noticeId") as? Double)?.toLong() ?: 0L
                )
            }
            NotificationData.Type.EVENT -> {
                NotificationData.Info.EventInfo(
                    eventId = (content?.get("eventId") as? Double)?.toLong() ?: 0L,
                    eventUrl = (content?.get("eventUrl") as? String) ?: "",
                    eventName = (content?.get("eventName") as? String) ?: "",
                    eventType = (content?.get("eventType") as? String) ?: "",
                )
            }
            NotificationData.Type.PRODUCT -> {
                NotificationData.Info.ProductInfo(
                    postId = (content?.get("postId") as? Double)?.toLong() ?: 0L,
                    commentId = (content?.get("commentId") as? Double)?.toLong() ?: 0L,
                    postUserId = (content?.get("postUserId") as? Double)?.toLong() ?: 0L,
                    commentUserId = (content?.get("commentUserId") as? Double)?.toLong() ?: 0L,
                )
            }

            NotificationData.Type.POST -> {
                NotificationData.Info.PostInfo(
                    postId = (content?.get("postId") as? Double)?.toLong() ?: 0L,
                    commentId = (content?.get("commentId") as? Double)?.toLong() ?: 0L,
                    postUserId = (content?.get("postUserId") as? Double)?.toLong() ?: 0L,
                    commentUserId = (content?.get("commentUserId") as? Double)?.toLong() ?: 0L,
                )
            }

            NotificationData.Type.USER_PRODUCT -> {
                NotificationData.Info.UserProductInfo(
                    postId = (content?.get("postId") as? Double)?.toLong() ?: 0L,
                    commentId = (content?.get("commentId") as? Double)?.toLong() ?: 0L,
                    postUserId = (content?.get("postUserId") as? Double)?.toLong() ?: 0L,
                    commentUserId = (content?.get("commentUserId") as? Double)?.toLong() ?: 0L,
                )
            }
            else -> {
                throw Exception("Notification Type Error")
            }
        }
    }
}