package com.rightcode.huespine.data.model

import com.rightcode.huespine.data.util.SafeEnumValue
import java.util.*

data class PostCommentData(
    val id: Long,
    val postId: Long,
    val parentId: Long?,
    val userId: Long,
    val status: Status,
    val content: String,
    val likedCount: Int,
    val createdAt: Date,
    val profileName: String,
    val profileImage: String,
    val liked: Boolean
) {
    enum class Status : SafeEnumValue {
        SHOW {
            override val value: String
                get() = "show"
        },
        BLOCKED {
            override val value: String
                get() = "blocked"
        },
        NONE {
            override val value: String
                get() = ""
        };
    }
}