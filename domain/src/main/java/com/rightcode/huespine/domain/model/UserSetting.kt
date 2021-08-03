package com.rightcode.huespine.domain.model

data class UserSetting(
    val userId: Long,
    val agreeMarketing: Boolean,
    val allowOfflinePush: ArrayList<String>,
    val allowOnlinePush: Boolean,
    val allowSinglePush: Boolean,
    val allSpecialPush: Boolean,
)