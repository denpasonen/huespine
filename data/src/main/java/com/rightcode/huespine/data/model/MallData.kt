package com.rightcode.huespine.data.model

data class MallData(
    val id: Long,
    val name: String,
    val path: String?,
    val titleImage: String?,
    val source: Source,
    val type: String,
    val category: Category,
    val hashtagIds: List<Long>?,
    val likedCount: Int?,
    val liked: Boolean,
    val recommended: Boolean?,
    val viewCount: Int?
) {

    data class Source(
        val name: String,
        val url: String,
    )

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