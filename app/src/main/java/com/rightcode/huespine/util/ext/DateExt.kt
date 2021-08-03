package com.rightcode.huespine.util.ext

import android.util.Log
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    return SimpleDateFormat(format, locale).format(this)
}

fun Date.fromUTC(toTimeZone: TimeZone = TimeZone.getDefault()): Date {
    return Date(this.time + toTimeZone.getOffset(this.time))
}

fun Date.toInstantCompat(): Instant {
    return Instant.ofEpochMilli(this.time)
}

fun Date.ignoreTime(): Date {
    return Calendar.getInstance().apply {
        time = this@ignoreTime
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.time
}

fun Date.toLocalDate(): LocalDate {
    return this.toInstantCompat().atZone(ZoneId.systemDefault()).toLocalDate()
}

infix fun Date.numberOfDays(end: Date): Long {
    return (end.ignoreTime().time - this.ignoreTime().time).absoluteValue / TimeUnit.DAYS.toMillis(
        1L
    )
}

fun Date.format(format: String): String =
    SimpleDateFormat(format, Locale.getDefault()).format(this)

fun Date.localizedTime(): String {
    val localDate = this.fromUTC()

    val nowMills = Instant.now().toEpochMilli()
    val createdMills = localDate.time
    val mills = nowMills - createdMills
    val minutes = mills / 1_000 / 60
    val hours = minutes / 60
    if (hours < 1) {
        return String.format("%d분 전", minutes)
    }
    if (hours < 24) {
        return String.format("%d시간 전", hours)

    }
    return localDate.format("yyyy년 MM월 dd일")
}
