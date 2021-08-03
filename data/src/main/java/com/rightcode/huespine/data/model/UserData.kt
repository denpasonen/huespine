package com.rightcode.huespine.data.model

import java.util.*

data class UserData(
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: Date,
    val profileId: Int,
    val profileName: String,
    val profileImage: String
)
