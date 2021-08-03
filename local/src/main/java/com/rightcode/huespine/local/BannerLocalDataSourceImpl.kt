package com.rightcode.huespine.local

import com.rightcode.huespine.data.source.local.BannerLocalDataSource
import com.rightcode.huespine.local.preferences.BannerPref
import com.rightcode.huespine.local.utils.rx.ext.mapToDataError
import com.rightcode.huespine.local.utils.rx.schedulers.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.internal.operators.completable.CompletableDefer
import javax.inject.Inject

internal class BannerLocalDataSourceImpl @Inject constructor(
    private val bannerPref: BannerPref,
    private val schedulerProvider: SchedulerProvider
) : BannerLocalDataSource {
    override var notShowToday: String?
        get() = bannerPref.notShowToday
        set(value) {
            bannerPref.notShowToday = value
        }

    override fun save(notShowToday: String): Completable {
        return CompletableDefer {
            bannerPref.notShowToday = notShowToday
            Completable.complete()
        }.subscribeOn(schedulerProvider.io)
            .mapToDataError()
    }
}