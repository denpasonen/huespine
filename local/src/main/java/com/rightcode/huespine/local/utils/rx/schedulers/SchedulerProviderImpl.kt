package com.rightcode.huespine.local.utils.rx.schedulers

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


internal class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {

    override val io: Scheduler
        get() = Schedulers.io()

    override val computation: Scheduler
        get() = Schedulers.computation()
}