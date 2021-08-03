package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class EventResponse(
    @SerializedName("id")
    @Expose
    val id: Long,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("location")
    @Expose
    val location: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("startAt")
    @Expose
    val startAt: Date,
    @SerializedName("endAt")
    @Expose
    val endAt: Date,
    @SerializedName("exposeAt")
    @Expose
    val exposeAt: Date,
    @SerializedName("createdAt")
    @Expose
    val createdAt: Date,
    @SerializedName("subscribe")
    @Expose
    val subscribe: Boolean
)
