package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class GetUserProductCommentListResponse(
    @SerializedName("data")
    @Expose val `data`: List<Data>,
    @SerializedName("total")
    @Expose val total: Int
) {
    data class Data(
        @SerializedName("id")
        @Expose val id: Long,
        @SerializedName("productId")
        @Expose val productId: Long,
        @SerializedName("parentId")
        @Expose val parentId: Long?,
        @SerializedName("userId")
        @Expose val userId: Long,
        @SerializedName("status")
        @Expose val status: String,
        @SerializedName("content")
        @Expose val content: String,
        @SerializedName("likedCount")
        @Expose val likedCount: Int,
        @SerializedName("createdAt")
        @Expose val createdAt: Date,
        @SerializedName("liked")
        @Expose val liked: Boolean?,
        @SerializedName("name")
        @Expose val profileName: String,
        @SerializedName("profileImage")
        @Expose val profileImage: String
    )
}