package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Contacts
import io.reactivex.Single

interface ContactsService {
    fun postContacts(
        type: String,
        title: String,
        content: String,
        email: String,
    ): Single<Contacts>
}