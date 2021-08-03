package com.rightcode.huespine.util.rx.ext

import com.rightcode.huespine.util.rx.operator.MaterializeSingleOperator
import io.reactivex.Notification
import io.reactivex.Single

fun <T> Single<T>.materializeCompat(): Single<Notification<T>> {
    return this.lift(MaterializeSingleOperator())
}
