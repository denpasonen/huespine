package com.rightcode.huespine.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class UserProduct(
    val id: Long,
    val userId: Long,
    val type: com.rightcode.huespine.domain.model.UserProduct.Type,
    val status: com.rightcode.huespine.domain.model.UserProduct.Status,
    val title: String,
    val description: String,
    val images: List<String>,
    val price: Int,
    val endAt: Date?,
    val likedCount: Int,
    val commentCount: Int,
    val createdAt: Date,
    val updatedAt: Date?,
    val dealType: List<com.rightcode.huespine.domain.model.UserProduct.DealType>?,
    val profileName: String,
    val profileImage: String,
    val liked: Boolean,
    val freeShipping: Boolean
) : Parcelable {
    enum class DealType {
        DIRECT, DELIVERY, POST, NONE;

        override fun toString(): String {
            return when (this) {
                com.rightcode.huespine.domain.model.UserProduct.DealType.DIRECT -> "direct"
                com.rightcode.huespine.domain.model.UserProduct.DealType.DELIVERY -> "delivery"
                com.rightcode.huespine.domain.model.UserProduct.DealType.POST -> "post"
                com.rightcode.huespine.domain.model.UserProduct.DealType.NONE -> "direct"
            }
        }
    }

    enum class Type {
        SELL, BUY, SHARE, AUCTION, NONE;

        override fun toString(): String {
            return when (this) {
                com.rightcode.huespine.domain.model.UserProduct.Type.SELL -> "sell"
                com.rightcode.huespine.domain.model.UserProduct.Type.BUY -> "buy"
                com.rightcode.huespine.domain.model.UserProduct.Type.SHARE -> "share"
                com.rightcode.huespine.domain.model.UserProduct.Type.AUCTION -> "auction"
                com.rightcode.huespine.domain.model.UserProduct.Type.NONE -> "sell"
            }
        }
    }

    enum class Status {
        ING, DONE, NONE;

        override fun toString(): String {
            return when (this) {
                com.rightcode.huespine.domain.model.UserProduct.Status.ING -> "ing"
                com.rightcode.huespine.domain.model.UserProduct.Status.DONE -> "done"
                com.rightcode.huespine.domain.model.UserProduct.Status.NONE -> "ing"
            }
        }
    }

}