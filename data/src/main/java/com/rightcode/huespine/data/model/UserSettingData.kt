package com.rightcode.huespine.data.model

data class UserSettingData(
    val userId: Long,
    val agreeMarketing: Boolean,
    val allowOfflinePush: ArrayList<String>,
    val allowOnlinePush: Boolean,
    val allowSinglePush: Boolean,
    val allSpecialPush: Boolean,
)