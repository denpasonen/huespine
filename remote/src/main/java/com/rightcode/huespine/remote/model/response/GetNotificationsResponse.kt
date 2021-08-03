package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class GetNotificationsResponse(
    @SerializedName("data")
    @Expose val `data`: List<Data>,
    @SerializedName("total")
    @Expose val total: Int
) {
    data class Data(
        @SerializedName("id")
        @Expose val id: Long,
        @SerializedName("userId")
        @Expose val userId: Long,
        @SerializedName("title")
        @Expose val title: String,
        @SerializedName("type")
        @Expose val type: String,
        @SerializedName("description")
        @Expose val description: String,
        @SerializedName("info")
        @Expose val info: Map<String, Any>?,
        @SerializedName("read")
        @Expose val read: Boolean,
        @SerializedName("createdAt")
        @Expose val createdAt: Date,
        @SerializedName("updatedAt")
        @Expose val updatedAt: Date
    )
}