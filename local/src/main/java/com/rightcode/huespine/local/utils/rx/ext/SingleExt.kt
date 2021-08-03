package com.rightcode.huespine.local.utils.rx.ext

import com.rightcode.huespine.local.mapper.exception.KKExceptionMapper
import io.reactivex.Single

internal fun <T> Single<T>.mapToDataError(): Single<T> {
    return this.onErrorResumeNext { exception ->
        Single.error(KKExceptionMapper.mapToData(exception))
    }
}