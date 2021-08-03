package com.rightcode.huespine.domain.model

import java.io.Serializable

data class Category(
    val id: Int,
    val parentId: Int?,
    val name: String = "",
    val onboardImage: String = "",
    val image: String = "",
    var selected: Boolean = false,
    val order: Long = 0L,
    val createdAt: String? = ""
):Serializable
