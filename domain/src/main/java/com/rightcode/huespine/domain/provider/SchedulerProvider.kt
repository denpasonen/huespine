package com.rightcode.huespine.domain.provider

import io.reactivex.Scheduler

interface SchedulerProvider {
    val ui: Scheduler

    val io: Scheduler

    val computation: Scheduler
}