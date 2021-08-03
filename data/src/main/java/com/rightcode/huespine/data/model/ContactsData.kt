package com.rightcode.huespine.data.model

import java.util.*

data class ContactsData(
    val id: Int,
    val status: String,
    val email: String,
    val content: String,
    val answer: String,
    val answeredAt: Date,
    val createdAt: Date,
)