package com.rightcode.huespine.data.mapper

internal interface Mapper<E, D> {
    fun mapToDomain(from: E): D
}