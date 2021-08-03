package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class GetUserProductResponse(
    @SerializedName("id")
    @Expose val id: Long,
    @SerializedName("userId")
    @Expose val userId: Long,
    @SerializedName("type")
    @Expose val type: String,
    @SerializedName("status")
    @Expose val status: String,
    @SerializedName("title")
    @Expose val title: String,
    @SerializedName("description")
    @Expose val description: String,
    @SerializedName("images")
    @Expose val images: List<String>,
    @SerializedName("price")
    @Expose val price: Int,
    @SerializedName("endAt")
    @Expose val endAt: Date?,
    @SerializedName("likedCount")
    @Expose val likedCount: Int,
    @SerializedName("commentCount")
    @Expose val commentCount: Int,
    @SerializedName("createdAt")
    @Expose val createdAt: Date,
    @SerializedName("updatedAt")
    @Expose val updatedAt: Date?,
    @SerializedName("dealType")
    @Expose val dealType: List<String>?,
    @SerializedName("name")
    @Expose val profileName: String,
    @SerializedName("profileImage")
    @Expose val profileImage: String,
    @SerializedName("freeShipping")
    @Expose val freeShipping: Boolean,
    @SerializedName("liked")
    @Expose val liked: Boolean?
)

