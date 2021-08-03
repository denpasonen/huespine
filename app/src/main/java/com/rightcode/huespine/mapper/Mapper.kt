package com.rightcode.huespine.mapper

internal interface Mapper<D, V> {
    fun mapToView(from: D): V
}