package com.rightcode.huespine.model

interface Identifiable {
    val identifier: Any

    override operator fun equals(other: Any?): Boolean

    fun same(other: Identifiable): Boolean {
        return equals(other)
    }
}