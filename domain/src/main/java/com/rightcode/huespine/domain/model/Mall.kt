package com.rightcode.huespine.domain.model


data class Mall(
    val id: Long,
    val name: String,
    val path: String?,
    val titleImage: String?,
    val source: com.rightcode.huespine.domain.model.Source,
    val type: String,
    val category: com.rightcode.huespine.domain.model.Category,
    val hashtagIds: List<Long>?,
    var likedCount: Int?,
    var liked: Boolean,
    val recommended: Boolean?,
    val viewCount: Int?,
)