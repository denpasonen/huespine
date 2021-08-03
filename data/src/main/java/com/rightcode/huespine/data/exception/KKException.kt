package com.rightcode.huespine.data.exception

import java.io.IOException

class KKException(
    message: String,
    cause: Throwable,
    val statusCode: Int = com.rightcode.huespine.data.exception.KKException.Companion.UNKNOWN_ERROR
) : IOException(message, cause) {
    companion object {
        const val UNKNOWN_ERROR = -1
    }
}