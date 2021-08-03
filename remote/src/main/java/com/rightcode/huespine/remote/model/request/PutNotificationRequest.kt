package com.rightcode.huespine.remote.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PutNotificationRequest(
    @SerializedName("ids")
    @Expose val ids: List<Long>

)
