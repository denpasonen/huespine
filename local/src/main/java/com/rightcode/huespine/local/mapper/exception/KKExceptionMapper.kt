package com.rightcode.huespine.local.mapper.exception

import com.rightcode.huespine.data.exception.KKException


internal object KKExceptionMapper : ExceptionMapper<Throwable, KKException> {
    override fun mapToData(from: Throwable): KKException {
        return KKException(
            message = from.message ?: "",
            cause = from,
        )
    }
}