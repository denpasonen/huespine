package com.rightcode.huespine.domain.repository


import com.rightcode.huespine.domain.model.Contacts
import io.reactivex.Single

interface ContactsRepository {
    fun postContact(type: String, title: String, content: String, email: String): Single<Contacts>
}