package com.rightcode.huespine.util.rx.scheduler

import com.rightcode.huespine.domain.provider.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {
    override val ui: Scheduler
        get() = AndroidSchedulers.mainThread()

    override val io: Scheduler
        get() = Schedulers.io()

    override val computation: Scheduler
        get() = Schedulers.computation()
}