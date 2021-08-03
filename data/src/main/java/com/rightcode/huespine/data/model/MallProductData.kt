package com.rightcode.huespine.data.model

data class MallProductData(
    val id: Long,
    val mallId: Long,
    val crawlerId: Long,
    val categoryId: Long,
    val category: List<Category>,
    val name: String,
    val price: Int,
    val discountRate: Int,
    val originalPrice: Int,
    val onSale: Boolean,
    val pinned: Boolean,
    val soldOut: Boolean,
    val likedCount: Int,
    val titleImage: String,
    val images: List<String>,
    val sourceUrl: String,
    val createdAt: String,
    val updatedAt: String?,
    val mallName: String,
    val liked: Boolean,
    val mallLiked: Boolean
){
    data class Category(
        val id: Long,
        val parentId: Long?,
        val name: String,
        val onboardImage: String,
        val image: String,
        val enabled: Boolean,
        val order: Int,
    )
}
