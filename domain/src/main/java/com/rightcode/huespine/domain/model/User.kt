package com.rightcode.huespine.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class User(
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: Date,
    val profileId: Int,
    val profileName: String,
    val profileImage: String
) : Parcelable
