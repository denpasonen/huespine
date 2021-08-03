package com.rightcode.huespine.util.ext

fun <E> Collection<E>.edit(block: MutableList<E>.() -> Unit): List<E> {
    return this.toMutableList().apply(block)
}