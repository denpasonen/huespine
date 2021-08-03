package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.NotificationData
import com.rightcode.huespine.domain.model.Notification

internal object NotificationListMapper :
    Mapper<Pair<List<NotificationData>, Int>, Pair<List<Notification>, Int>> {
    override fun mapToDomain(from: Pair<List<NotificationData>, Int>): Pair<List<Notification>, Int> {
        val (notifications, total) = from
        return notifications.map { notification ->
            Notification(
                id = notification.id,
                type = when (notification.type) {
                    NotificationData.Type.NONE -> Notification.Type.NONE
                    NotificationData.Type.PRODUCT -> Notification.Type.PRODUCT
                    NotificationData.Type.USER_PRODUCT -> Notification.Type.USER_PRODUCT
                    NotificationData.Type.POST -> Notification.Type.POST
                    NotificationData.Type.EVENT -> Notification.Type.EVENT
                    NotificationData.Type.NOTICE -> Notification.Type.NOTICE
                },
                description = notification.description,
                userId = notification.userId,
                info = when (notification.info) {
                    is NotificationData.Info.NoticeInfo -> {
                        Notification.Info.NoticeInfo(
                            noticeId = notification.info.noticeId
                        )
                    }
                    is NotificationData.Info.ProductInfo -> {
                        Notification.Info.ProductInfo(
                            postId = notification.info.postId,
                            commentId = notification.info.commentId,
                            postUserId = notification.info.postUserId,
                            commentUserId = notification.info.commentUserId
                        )
                    }
                    is NotificationData.Info.UserProductInfo -> {
                        Notification.Info.UserProductInfo(
                            postId = notification.info.postId,
                            commentId = notification.info.commentId,
                            postUserId = notification.info.postUserId,
                            commentUserId = notification.info.commentUserId
                        )
                    }
                    is NotificationData.Info.PostInfo -> {
                        Notification.Info.PostInfo(
                            postId = notification.info.postId,
                            commentId = notification.info.commentId,
                            postUserId = notification.info.postUserId,
                            commentUserId = notification.info.commentUserId
                        )
                    }
                    is NotificationData.Info.EventInfo -> {
                        Notification.Info.EventInfo(
                            eventId = notification.info.eventId,
                            eventUrl = notification.info.eventUrl,
                            eventName = notification.info.eventName,
                            eventType = notification.info.eventType
                        )
                    }
                    null -> null
                },
                read = notification.read,
                createdAt = notification.createdAt,
                title = notification.title,
                updatedAt = notification.updatedAt
            )
        } to total
    }
}