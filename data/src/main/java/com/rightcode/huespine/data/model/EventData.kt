package com.rightcode.huespine.data.model

import java.util.*

data class EventData(
    val id: Long,
    val name: String,
    val type: String,
    val location: String,
    val url: String,
    val startAt: Date,
    val endAt: Date,
    val exposeAt: Date,
    val createdAt: Date,
    val subscribe: Boolean
)