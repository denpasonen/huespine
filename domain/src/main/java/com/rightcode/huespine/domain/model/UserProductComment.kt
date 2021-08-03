package com.rightcode.huespine.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class UserProductComment(
    val id: Long,
    val productId: Long,
    val parentId: Long?,
    val userId: Long,
    val status: com.rightcode.huespine.domain.model.UserProductComment.Status,
    val content: String,
    val likedCount: Int,
    val createdAt: Date,
    val profileName: String,
    val profileImage: String,
    val liked: Boolean,
    val isMine: Boolean
) : Parcelable {
    enum class Status {
        SHOW,
        BLOCKED,
        NONE;
    }
}