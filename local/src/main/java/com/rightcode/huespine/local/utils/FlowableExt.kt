package com.rightcode.huespine.local.utils

import io.reactivex.Flowable
import java.util.*

internal fun <T> Flowable<T>.optionalize(): Flowable<Optional<T>> {
    return this.lift(OptionalizeFlowableOperator())
}
