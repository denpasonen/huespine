package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.EventData
import com.rightcode.huespine.remote.model.response.EventResponse

internal object EventMapper : Mapper<EventResponse, EventData> {
    override fun mapToData(from: EventResponse): EventData {
        return EventData(
            id = from.id,
            name = from.name,
            type = from.type,
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

