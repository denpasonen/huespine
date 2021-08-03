package com.rightcode.huespine.remote.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal enum class FileType {
    @SerializedName("image")
    @Expose
    IMAGE,

    @SerializedName("file")
    @Expose
    FILE;
}