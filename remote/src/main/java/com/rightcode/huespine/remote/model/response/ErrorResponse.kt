package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class ErrorResponse(
    @SerializedName("message")
    @Expose
    val message: String
)