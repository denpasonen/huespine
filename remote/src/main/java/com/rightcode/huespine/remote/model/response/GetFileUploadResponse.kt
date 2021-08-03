package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class GetFileUploadResponse(
    @SerializedName("path")
    @Expose
    val path: String,

    @SerializedName("url")
    @Expose
    val url: String
)