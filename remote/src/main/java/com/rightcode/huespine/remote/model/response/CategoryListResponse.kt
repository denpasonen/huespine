package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class CategoryListResponse(

    @SerializedName("data")
    @Expose
    val data: List<CategoryResponse>,

    @SerializedName("total")
    @Expose
    val total: Int
) {
    data class CategoryResponse(
        @SerializedName("id")
        @Expose
        val id: Int,
        @SerializedName("parentId")
        @Expose
        val parentId: Int,

        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("onboardImage")
        @Expose
        val onboardImage: String,

        @SerializedName("image")
        @Expose
        val image: String,

        @SerializedName("order")
        @Expose
        val order: Long,

        @SerializedName("createdAt")
        @Expose
        val createdAt: String?
    )
}
