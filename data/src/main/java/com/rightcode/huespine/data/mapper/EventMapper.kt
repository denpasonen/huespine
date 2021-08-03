package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.EventData
import com.rightcode.huespine.domain.model.Event
import com.rightcode.huespine.domain.model.type.EventType
import java.util.*

internal object EventMapper : Mapper<EventData, Event> {
    override fun mapToDomain(from: EventData): Event {
        return Event(
            id = from.id,
            name = from.name,
            type = EventType.valueOf(from.type.toUpperCase(Locale.getDefault())),
            location = from.location,
            url = from.url,
            startAt = from.startAt,
            endAt = from.endAt,
            exposeAt = from.exposeAt,
            createdAt = from.createdAt,
            subscribe = from.subscribe
        )
    }
}
