package com.rightcode.huespine.local.preferences

import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

internal interface SearchPref {
    var searchList: Set<String>?

    fun getSearchList(): Flowable<Optional<Set<String>>>
}