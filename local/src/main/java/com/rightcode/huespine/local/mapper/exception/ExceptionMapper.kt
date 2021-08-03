package com.rightcode.huespine.local.mapper.exception

internal interface ExceptionMapper<E, D> {
    fun mapToData(from: E): D
}