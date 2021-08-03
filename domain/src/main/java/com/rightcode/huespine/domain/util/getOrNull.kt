package com.rightcode.huespine.domain.util

import java.util.*

fun <E> Optional<E>.getOrNull(): E? {
    return if (this.isPresent) this.get() else null
}