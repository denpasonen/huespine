package com.rightcode.huespine.remote.utils.rx.schedulers

import io.reactivex.Scheduler

internal interface SchedulerProvider {
    val io: Scheduler

    val computation: Scheduler
}