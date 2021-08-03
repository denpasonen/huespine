package com.rightcode.huespine.remote.mapper

internal interface EnumMapper<R : Enum<*>, D : Enum<*>> {
    fun mapToData(from: R): D

    fun mapFromData(from: D): R
}