package com.rightcode.huespine.remote.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostRequest(
    @SerializedName("type")
    @Expose val type: String,
    @SerializedName("images")
    @Expose val images: List<String>,
    @SerializedName("description")
    @Expose val description: String
)
