package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.EventData
import com.rightcode.huespine.remote.model.response.EventResponse

internal object EventListMapper : Mapper<List<EventResponse>, List<EventData>> {
    override fun mapToData(from: List<EventResponse>): List<EventData> {
        return from.map { event ->
            EventData(
                id = event.id,
                name = event.name,
                type = event.type,
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

