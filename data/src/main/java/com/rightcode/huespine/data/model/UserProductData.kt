package com.rightcode.huespine.data.model

import com.rightcode.huespine.data.util.SafeEnumValue
import java.util.*

data class UserProductData(
    val id: Long,
    val userId: Long,
    val type: Type,
    val status: Status,
    val title: String,
    val description: String,
    val images: List<String>,
    val price: Int,
    val endAt: Date?,
    val likedCount: Int,
    val commentCount: Int,
    val createdAt: Date,
    val updatedAt: Date?,
    val dealType: List<DealType>?,
    val profileName: String,
    val profileImage: String,
    val freeShipping: Boolean,
    val liked: Boolean?
) {
    enum class DealType : SafeEnumValue {
        DIRECT {
            override val value: String
                get() = "direct"
        },
        DELIVERY {
            override val value: String
                get() = "delivery"
        },
        POST {
            override val value: String
                get() = "post"
        },
        NONE {
            override val value: String
                get() = ""
        };
    }

    enum class Type : SafeEnumValue {
        SELL {
            override val value: String
                get() = "sell"
        },
        BUY {
            override val value: String
                get() = "buy"
        },
        SHARE {
            override val value: String
                get() = "share"
        },
        AUCTION {
            override val value: String
                get() = "auction"
        },
        NONE {
            override val value: String
                get() = ""
        };
    }

    enum class Status : SafeEnumValue {
        ING {
            override val value: String
                get() = "ing"
        },
        DONE {
            override val value: String
                get() = "done"
        },
        NONE {
            override val value: String
                get() = ""
        };
    }

}