package com.rightcode.huespine.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Post(
    val id: Long,
    val userId: Long,
    val type: com.rightcode.huespine.domain.model.Post.PostType,
    val images: List<String>,
    val description: String,
    val status: String,
    val likedCount: Int,
    val commentCount: Int,
    val createdAt: Date,
    val profileName: String,
    val profileImage: String,
    val liked: Boolean
) : Parcelable {
    enum class PostType {
        TALK, QUESTION, BOUGHT, DESIGNED, NONE;

        override fun toString(): String {
            return when (this) {
                com.rightcode.huespine.domain.model.Post.PostType.TALK -> "talk"
                com.rightcode.huespine.domain.model.Post.PostType.QUESTION -> "question"
                com.rightcode.huespine.domain.model.Post.PostType.BOUGHT -> "bought"
                com.rightcode.huespine.domain.model.Post.PostType.DESIGNED -> "designed"
                else -> ""
            }
        }
    }
}
