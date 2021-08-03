package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.EventData
import com.rightcode.huespine.domain.model.Event
import com.rightcode.huespine.domain.model.type.EventType
import java.util.*

internal object EventListMapper : Mapper<List<EventData>, List<Event>> {
    override fun mapToDomain(from: List<EventData>): List<Event> {
        return from.map { event ->
            Event(
                id = event.id,
                name = event.name,
                type = EventType.valueOf(event.type.toUpperCase(Locale.getDefault())),
                location = event.location,
                url = event.url,
                startAt = event.startAt,
                endAt = event.endAt,
                exposeAt = event.exposeAt,
                createdAt = event.createdAt,
                subscribe = event.subscribe
            )
        }
    }
}