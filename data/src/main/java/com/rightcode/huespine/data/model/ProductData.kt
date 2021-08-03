package com.rightcode.huespine.data.model

import com.rightcode.huespine.domain.model.Category

data class ProductData(
    val id: Long,
    val mallId: Long,
    val crawlerId: Long,
    val categoryId: Long?,
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
    val mallName: String?,
    val liked: Boolean,
    val mallLiked: Boolean
)