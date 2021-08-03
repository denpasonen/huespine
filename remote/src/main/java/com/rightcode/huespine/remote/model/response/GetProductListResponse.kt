package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetProductListResponse(
    @SerializedName("data")
    @Expose val `data`: List<Data>,
    @SerializedName("total")
    @Expose val total: Int
) {
    data class Data(
        @SerializedName("id")
        @Expose val id: Long,
        @SerializedName("mallId")
        @Expose val mallId: Long,
        @SerializedName("crawlerId")
        @Expose val crawlerId: Long,
        @SerializedName("categoryId")
        @Expose val categoryId: Long?,
        @SerializedName("category")
        @Expose val category: List<Category>,
        @SerializedName("name")
        @Expose val name: String,
        @SerializedName("price")
        @Expose val price: Int,
        @SerializedName("discountRate")
        @Expose val discountRate: Int,
        @SerializedName("originalPrice")
        @Expose val originalPrice: Int,
        @SerializedName("onSale")
        @Expose val onSale: Boolean,
        @SerializedName("pinned")
        @Expose val pinned: Boolean,
        @SerializedName("soldOut")
        @Expose val soldOut: Boolean,
        @SerializedName("likedCount")
        @Expose val likedCount: Int,
        @SerializedName("titleImage")
        @Expose val titleImage: String,
        @SerializedName("images")
        @Expose val images: List<String>,
        @SerializedName("sourceUrl")
        @Expose val sourceUrl: String,
        @SerializedName("createdAt")
        @Expose val createdAt: String,
        @SerializedName("updatedAt")
        @Expose val updatedAt: String?,
        @SerializedName("mallName")
        @Expose val mallName: String,
        @SerializedName("liked")
        @Expose val liked: Boolean,
        @SerializedName("mallLiked")
        @Expose val mallLiked: Boolean
    ) {
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
            @SerializedName("createdAt")
            @Expose val createdAt: String
        )
    }

}
