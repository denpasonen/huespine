package com.rightcode.huespine.data.mapper

internal interface EnumMapper<E : Enum<*>, D : Enum<*>> {
    fun mapToDomain(from: E): D

    fun mapFromDomain(from: D): E
}