package com.rightcode.huespine.local.utils.rx.ext

import com.rightcode.huespine.local.mapper.exception.KKExceptionMapper
import io.reactivex.Completable

internal fun Completable.mapToDataError(): Completable {
    return this.onErrorResumeNext { exception ->
        Completable.error(KKExceptionMapper.mapToData(exception))
    }
}