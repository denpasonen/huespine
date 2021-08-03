package com.rightcode.huespine.local.utils.rx.ext

import com.rightcode.huespine.local.mapper.exception.KKExceptionMapper
import io.reactivex.Observable

internal fun <T> Observable<T>.mapToDataError(): Observable<T> {
    return this.onErrorResumeNext { exception: Throwable ->
        Observable.error(KKExceptionMapper.mapToData(exception))
    }
}