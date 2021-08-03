package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Event
import com.rightcode.huespine.domain.repository.EventRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class EventServiceImpl @Inject constructor(
    private val eventRepository: EventRepository
) : EventService {

    override fun getEvents(startDate: String, endDate: String): Single<List<Event>> {
        return eventRepository.getEvents(startDate, endDate)
    }

    override fun postEvents(id: Long): Completable {
        return eventRepository.postEvents(id)
    }

    override fun deleteEvents(id: Long): Completable {
        return eventRepository.deleteEvents(id)
    }

    override fun getEvent(id: Long): Single<Event> {
        return eventRepository.getEvent(id)
    }
}