package com.rightcode.huespine.remote.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommentRequest(
    @SerializedName("parentId")
    @Expose val parentId: Long?,
    @SerializedName("content")
    @Expose val content: String
)
