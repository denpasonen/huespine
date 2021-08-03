package com.rightcode.huespine.remote.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostAuthSocialRegisterRequest(
    @SerializedName("type")
    @Expose val type: String,
    @SerializedName("platform")
    @Expose val platform: String? = "android",
    @SerializedName("token")
    @Expose val token: String,
    @SerializedName("name")
    @Expose val name: String,
    @SerializedName("profileId")
    @Expose val profileId: Int,
    @SerializedName("tasteIds")
    @Expose val tasteIds: List<Int>,
    @SerializedName("categoryIds")
    @Expose val categoryIds: List<Int>
)
