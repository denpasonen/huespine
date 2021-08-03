package com.rightcode.huespine.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Long,
    val mallId: Long,
    val crawlerId: Long,
    val category: List<com.rightcode.huespine.domain.model.Category>,
    val categoryId: Long?,
    val name: String,
    val price: Int,
    val discountRate: Int,
    val originalPrice: Int?,
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
) : Parcelable