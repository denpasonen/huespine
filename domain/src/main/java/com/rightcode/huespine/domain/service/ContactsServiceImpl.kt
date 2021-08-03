package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Contacts
import com.rightcode.huespine.domain.repository.ContactsRepository
import io.reactivex.Single
import javax.inject.Inject

class ContactsServiceImpl @Inject constructor(
    private val contactsRepository: ContactsRepository
) : ContactsService {

    override fun postContacts(
        type: String,
        title: String,
        content: String,
        email: String
    ): Single<Contacts> {
        return contactsRepository.postContact(type, title, content, email)
    }
}