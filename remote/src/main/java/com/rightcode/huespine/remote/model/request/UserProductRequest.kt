package com.rightcode.huespine.remote.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserProductRequest(
    @SerializedName("type")
    @Expose val type: String,
    @SerializedName("dealType")
    @Expose val dealType: List<String>,
    @SerializedName("title")
    @Expose val title: String,
    @SerializedName("description")
    @Expose val description: String,
    @SerializedName("images")
    @Expose val images: List<String>,
    @SerializedName("price")
    @Expose val price: Int? = null,
    @SerializedName("endAt")
    @Expose val endAt: String?,
    @SerializedName("status")
    @Expose val status: String?,
    @SerializedName("freeShipping")
    @Expose val freeShipping: Boolean
)
