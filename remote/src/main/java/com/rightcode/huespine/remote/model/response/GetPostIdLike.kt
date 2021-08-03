package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetPostIdLike(
    @SerializedName("id")
    @Expose val id: Long,
    @SerializedName("name")
    @Expose val name: String,
    @SerializedName("profileName")
    @Expose val profileName: String,
    @SerializedName("image")
    @Expose val image: String
)
