package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.EventListMapper
import com.rightcode.huespine.data.mapper.EventMapper
import com.rightcode.huespine.data.source.remote.EventRemoteDataSource
import com.rightcode.huespine.domain.model.Event
import com.rightcode.huespine.domain.repository.EventRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val remote: EventRemoteDataSource
) : EventRepository {
    override fun postEvents(id: Long): Completable {
        return remote.postEvents(id)
    }

    override fun deleteEvents(id: Long): Completable {
        return remote.deleteEvents(id)
    }

    override fun getEvents(startDate: String, endDate: String): Single<List<Event>> =
        remote.getEvents(startDate, endDate)
            .map(EventListMapper::mapToDomain)

    override fun getEvent(id: Long): Single<Event> {
        return remote.getEvent(id)
            .map(EventMapper::mapToDomain)
    }
}