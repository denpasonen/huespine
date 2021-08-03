package com.rightcode.huespine.remote.mapper

internal interface Mapper<R, D> {
    fun mapToData(from: R): D
}