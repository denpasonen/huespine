package com.rightcode.huespine.data.model

import java.util.*

data class UserProfileData(
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: Date,
    val profileId: Int,
    val profileName: String,
    val profileImage: String,
    val level: Int,
    val likeCount: Int,
    val postCount: Int,
    val tastes: List<Int>,
    val category: List<Int>
)
