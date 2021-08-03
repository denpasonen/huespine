package com.rightcode.huespine.local.preferences

import io.reactivex.Flowable
import java.util.*

internal interface SessionPref {
    var currentUserId: Long?
    var cookieSid: String?

    fun fetchUserId(): Flowable<Optional<Long>>
}