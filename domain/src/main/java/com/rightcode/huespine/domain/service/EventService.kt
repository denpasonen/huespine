package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Event
import io.reactivex.Completable
import io.reactivex.Single

interface EventService {
    fun getEvents(startDate: String, endDate: String): Single<List<Event>>

    fun postEvents(id: Long): Completable

    fun deleteEvents(id: Long): Completable

    fun getEvent(id: Long): Single<Event>
}