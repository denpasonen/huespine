package com.rightcode.huespine.local.utils.rx.schedulers

import io.reactivex.Scheduler

internal interface SchedulerProvider {
    val io: Scheduler

    val computation: Scheduler
}