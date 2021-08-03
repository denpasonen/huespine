package com.rightcode.huespine.data.source.local

import io.reactivex.Completable

interface BannerLocalDataSource {

    var notShowToday: String?

    fun save(notShowToday: String): Completable
}