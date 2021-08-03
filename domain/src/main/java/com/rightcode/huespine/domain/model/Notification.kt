package com.rightcode.huespine.domain.model

import java.util.*

data class Notification(
    val id: Long,
    val userId: Long,
    val title: String,
    val type: com.rightcode.huespine.domain.model.Notification.Type,
    val description: String,
    val info: com.rightcode.huespine.domain.model.Notification.Info?,
    val read: Boolean,
    val createdAt: Date,
    val updatedAt: Date
) {

    sealed class Info {
        data class NoticeInfo(
            val noticeId: Long
        ) : com.rightcode.huespine.domain.model.Notification.Info()

        data class EventInfo(
            val eventId: Long,
            val eventUrl: String,
            val eventName: String,
            val eventType: String

        ) : com.rightcode.huespine.domain.model.Notification.Info()

        data class ProductInfo(
            val postId: Long,
            val commentId: Long,
            val postUserId: Long,
            val commentUserId: Long
        ) : com.rightcode.huespine.domain.model.Notification.Info()

        data class PostInfo(
            val postId: Long,
            val commentId: Long,
            val postUserId: Long,
            val commentUserId: Long
        ) : com.rightcode.huespine.domain.model.Notification.Info()

        data class UserProductInfo(
            val postId: Long,
            val commentId: Long,
            val postUserId: Long,
            val commentUserId: Long
        ) : com.rightcode.huespine.domain.model.Notification.Info()
    }

    enum class Type {
        NOTICE,
        EVENT,
        PRODUCT,
        POST,
        USER_PRODUCT,
        NONE;
    }
}