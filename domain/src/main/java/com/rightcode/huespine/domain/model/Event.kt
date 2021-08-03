package com.rightcode.huespine.domain.model

import android.os.Parcelable
import com.rightcode.huespine.domain.model.type.EventType
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.*

@Parcelize
data class Event(
    val id: Long,
    val name: String,
    val type: EventType,
    val location: String,
    val url: String,
    val startAt: Date,
    val endAt: Date,
    val exposeAt: Date,
    val createdAt: Date,
    var subscribe: Boolean
) : Parcelable, Serializable