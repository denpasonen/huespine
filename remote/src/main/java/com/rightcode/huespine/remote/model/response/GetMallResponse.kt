package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetMallResponse(
    @SerializedName("id")
    @Expose val id: Long,
    @SerializedName("name")
    @Expose val name: String,
    @SerializedName("path")
    @Expose val path: String?,
    @SerializedName("titleImage")
    @Expose val titleImage: String?,
    @SerializedName("source")
    @Expose val source: Source,
    @SerializedName("type")
    @Expose val type: String,
    @SerializedName("category")
    @Expose val category: Category,
    @SerializedName("hashtagIds")
    @Expose val hashtagIds: List<Long>?,
    @SerializedName("liked")
    @Expose val liked: Boolean,
    @SerializedName("likedCount")
    @Expose val likedCount: Int?,
    @SerializedName("recommended")
    @Expose val recommended: Boolean?,
    @SerializedName("viewCount")
    @Expose val viewCount: Int?,
) {
    data class Source(
        @SerializedName("name")
        @Expose val name: String,
        @SerializedName("url")
        @Expose val url: String,
    )

    data class Category(
        @SerializedName("id")
        @Expose val id: Long,
        @SerializedName("parentId")
        @Expose val parentId: Long?,
        @SerializedName("name")
        @Expose val name: String,
        @SerializedName("onboardImage")
        @Expose val onboardImage: String,
        @SerializedName("image")
        @Expose val image: String,
        @SerializedName("enabled")
        @Expose val enabled: Boolean,
        @SerializedName("order")
        @Expose val order: Int,
    )
}

