package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.EventData
import io.reactivex.Completable
import io.reactivex.Single


interface EventRemoteDataSource {

    fun getEvents(startDate: String, endDate: String): Single<List<EventData>>

    fun postEvents(id: Long): Completable

    fun deleteEvents(id: Long): Completable

    fun getEvent(id: Long): Single<EventData>

}
