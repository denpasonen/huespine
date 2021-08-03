package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class GetUserSettingResponse(
    @SerializedName("userId")
    @Expose val userId: Long,

    @SerializedName("agreeMarketing")
    @Expose val agreeMarketing: Boolean,

    @SerializedName("allowOfflinePush")
    @Expose val allowOfflinePush: ArrayList<String>,

    @SerializedName("allowOnlinePush")
    @Expose val allowOnlinePush: Boolean,

    @SerializedName("allowSinglePush")
    @Expose val allowSinglePush: Boolean,

    @SerializedName("allSpecialPush")
    @Expose val allSpecialPush: Boolean,
)