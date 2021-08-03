package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.ContactsData
import com.rightcode.huespine.data.source.remote.ContactsRemoteDataSource
import com.rightcode.huespine.remote.mapper.ContactsMapper
import com.rightcode.huespine.remote.retrofit.api.ContactsApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class ContactsRemoteDataSourceImpl @Inject constructor(
    private val api: ContactsApi,
    private val gson: Gson
) : ContactsRemoteDataSource {

    override fun postContact(
        type: String,
        title: String,
        content: String,
        email: String
    ): Single<ContactsData> {
        val data =
            "{\"type\":\"$type\",\"title\":\"$title\",\"content\":\"$content\",\"email\":\"$email\"}"

        return api.postAuth(data.toRequestBody("application/json".toMediaType()))
            .map(ContactsMapper::mapToData)
            .catchRemoteError(gson)
    }
}