package com.rightcode.huespine.data.model

import com.rightcode.huespine.data.util.SafeEnumValue
import java.util.*

data class NotificationData(
    val id: Long,
    val userId: Long,
    val title: String,
    val type: Type,
    val description: String,
    val info: Info?,
    val read: Boolean,
    val createdAt: Date,
    val updatedAt: Date
) {

    sealed class Info {
        data class NoticeInfo(
            val noticeId: Long
        ) : Info()

        data class EventInfo(
            val eventId: Long,
            val eventUrl: String,
            val eventName: String,
            val eventType: String
        ) : Info()

        data class ProductInfo(
            val postId: Long,
            val commentId: Long,
            val postUserId: Long,
            val commentUserId: Long
        ) : Info()

        data class PostInfo(
            val postId: Long,
            val commentId: Long,
            val postUserId: Long,
            val commentUserId: Long
        ) : Info()

        data class UserProductInfo(
            val postId: Long,
            val commentId: Long,
            val postUserId: Long,
            val commentUserId: Long
        ) : Info()
    }

    enum class Type : SafeEnumValue {
        NOTICE {
            override val value: String
                get() = "notice"
        },
        EVENT {
            override val value: String
                get() = "event"
        },
        PRODUCT {
            override val value: String
                get() = "product"
        },
        POST {
            override val value: String
                get() = "post"
        },
        USER_PRODUCT {
            override val value: String
                get() = "userProduct"
        },
        NONE {
            override val value: String
                get() = ""
        };
    }
}