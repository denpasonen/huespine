package com.rightcode.huespine.data.model


data class CategoryData(
    val id: Int,
    val parentId: Int,
    val name: String,
    val onboardImage: String,
    val image: String,
    val order: Long,
    val createdAt: String?
)