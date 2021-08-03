package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class GetPostResponse(
    @SerializedName("id")
    @Expose val id: Long,
    @SerializedName("userId")
    @Expose val userId: Long,
    @SerializedName("type")
    @Expose val type: String,
    @SerializedName("images")
    @Expose val images: List<String>,
    @SerializedName("description")
    @Expose val description: String,
    @SerializedName("status")
    @Expose val status: String,
    @SerializedName("likedCount")
    @Expose val likedCount: Int,
    @SerializedName("commentCount")
    @Expose val commentCount: Int,
    @SerializedName("createdAt")
    @Expose val createdAt: Date,
    @SerializedName("name")
    @Expose val profileName: String,
    @SerializedName("profileImage")
    @Expose val profileImage: String,
    @SerializedName("liked")
    @Expose val liked: Boolean
)
