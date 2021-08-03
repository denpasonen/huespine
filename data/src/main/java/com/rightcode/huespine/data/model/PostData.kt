package com.rightcode.huespine.data.model

import com.rightcode.huespine.data.util.SafeEnumValue
import java.util.*

data class PostData(
    val id: Long,
    val userId: Long,
    val type: PostType,
    val images: List<String>,
    val description: String,
    val status: String,
    val likedCount: Int,
    val commentCount: Int,
    val createdAt: Date,
    val profileName: String,
    val profileImage: String,
    val liked: Boolean
) {
    enum class PostType : SafeEnumValue {
        TALK {
            override val value: String
                get() = "talk"
        },
        QUESTION {
            override val value: String
                get() = "question"
        },
        BUY {
            override val value: String
                get() = "bought"
        },
        DESIGNED {
            override val value: String
                get() = "designed"
        },
        NONE {
            override val value: String
                get() = ""
        };
    }
}