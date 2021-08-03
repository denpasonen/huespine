package com.rightcode.huespine.local.utils.rx.ext

import com.rightcode.huespine.local.mapper.exception.KKExceptionMapper
import io.reactivex.Flowable

internal fun <T> Flowable<T>.mapToDataError(): Flowable<T> {
    return this.onErrorResumeNext { exception: Throwable ->
        Flowable.error(KKExceptionMapper.mapToData(exception))
    }
}