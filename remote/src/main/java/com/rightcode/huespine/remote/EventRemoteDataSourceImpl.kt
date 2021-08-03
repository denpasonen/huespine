package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.EventData
import com.rightcode.huespine.data.source.remote.EventRemoteDataSource
import com.rightcode.huespine.remote.mapper.EventListMapper
import com.rightcode.huespine.remote.mapper.EventMapper
import com.rightcode.huespine.remote.retrofit.api.EventApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class EventRemoteDataSourceImpl @Inject constructor(
    private val api: EventApi,
    private val gson: Gson
) : EventRemoteDataSource {

    override fun getEvents(
        startDate: String,
        endDate: String
    ) = api.getEvents(startDate, endDate)
        .map(EventListMapper::mapToData)
        .catchRemoteError(gson)

    override fun postEvents(id: Long): Completable {
        return api.postEvent(
            "{\"eventId\":\"$id\"}"
                .toRequestBody("application/json".toMediaType())
        ).catchRemoteError(gson)
    }

    override fun deleteEvents(id: Long): Completable {
        return api.deleteEvent(id).catchRemoteError(gson)
    }

    override fun getEvent(id: Long): Single<EventData> {
        return api.getEvent(id)
            .map(EventMapper::mapToData)
            .catchRemoteError(gson)
    }
}
