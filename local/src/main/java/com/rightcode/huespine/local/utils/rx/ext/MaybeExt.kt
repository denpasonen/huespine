package com.rightcode.huespine.local.utils.rx.ext

import com.rightcode.huespine.local.mapper.exception.KKExceptionMapper
import io.reactivex.Maybe

internal fun <T> Maybe<T>.mapToDataError(): Maybe<T> {
    return this.onErrorResumeNext { exception: Throwable ->
        Maybe.error(KKExceptionMapper.mapToData(exception))
    }
}