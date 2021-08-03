package com.rightcode.huespine.domain.model

import java.util.*

data class Contacts(
    val id: Int,
    val status: String,
    val email: String,
    val content: String,
    val answer: String,
    val answeredAt: Date,
    val createdAt: Date,
)