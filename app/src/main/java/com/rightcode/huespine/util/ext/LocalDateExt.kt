package com.rightcode.huespine.util.ext

import org.threeten.bp.LocalDate
import java.text.SimpleDateFormat
import java.util.*

fun LocalDate.toDate(): Date {
    return Date(this.epochMilli)
}


fun LocalDate.compare(date: Date?): Boolean {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    return this == LocalDate.parse(sdf.format(date))
}

val LocalDate.epochMilli: Long
    get() {
        return this.atStartOfDay(org.threeten.bp.ZoneId.systemDefault()).toEpochSecond() * 1_000
    }


