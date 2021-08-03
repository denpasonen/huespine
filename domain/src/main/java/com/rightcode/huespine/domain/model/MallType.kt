package com.rightcode.huespine.domain.model

data class MallType(
    val id: Long,
    val name: String,
    var selected: Boolean = false,
)