package com.rightcode.huespine.domain.model

data class Hashtag(
    val id: Long,
    val name: String,
    var selected: Boolean = false,
)