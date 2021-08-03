package com.rightcode.huespine.local.preferences

import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

internal interface BannerPref {
    var notShowToday: String?

    fun getNoeShowDate(): Flowable<Optional<String>>
}