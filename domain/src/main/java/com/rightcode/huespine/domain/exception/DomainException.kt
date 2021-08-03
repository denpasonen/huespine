package com.rightcode.huespine.domain.exception

abstract class DomainException(
    message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause)