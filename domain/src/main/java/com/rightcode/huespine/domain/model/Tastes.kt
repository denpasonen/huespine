package com.rightcode.huespine.domain.model

data class Tastes(
    val id: Int,
    val mallTypeId: Int = 0,
    val name: String = "",
    val image: String = "",
    val order: Long = 0L,
    var selected:Boolean = false
)
