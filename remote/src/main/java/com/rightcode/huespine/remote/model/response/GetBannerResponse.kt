package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetBannerResponse(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("image")
    @Expose
    val image: String,
    @SerializedName("productIds")
    @Expose
    val productIds: List<Int>
)
