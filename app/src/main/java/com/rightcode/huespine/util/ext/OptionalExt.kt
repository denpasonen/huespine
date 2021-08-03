package com.rightcode.huespine.util.ext

import java.util.*

fun <E> Optional<E>.getOrNull(): E? {
    return if (this.isPresent) this.get() else null
}