package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetHashtagResponse(

    @SerializedName("id")
    @Expose val id: Long,
    @SerializedName("name")
    @Expose val name: String
)
