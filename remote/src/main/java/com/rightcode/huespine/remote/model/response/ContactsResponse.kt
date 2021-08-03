package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class ContactsResponse(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("content")
    @Expose
    val content: String,
    @SerializedName("answer")
    @Expose
    val answer: String,
    @SerializedName("answeredAt")
    @Expose
    val answeredAt: Date,
    @SerializedName("createdAt")
    @Expose
    val createdAt: Date
)
