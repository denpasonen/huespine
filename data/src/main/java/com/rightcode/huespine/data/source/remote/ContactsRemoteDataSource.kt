package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.ContactsData
import io.reactivex.Single


interface ContactsRemoteDataSource {
    fun postContact(
        type: String,
        title: String,
        content: String,
        email: String
    ): Single<ContactsData>
}
