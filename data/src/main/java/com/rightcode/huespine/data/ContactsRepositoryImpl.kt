package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.ContactsMapper
import com.rightcode.huespine.data.source.remote.ContactsRemoteDataSource
import com.rightcode.huespine.domain.model.Contacts
import com.rightcode.huespine.domain.repository.ContactsRepository
import io.reactivex.Single
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor(
    private val remote: ContactsRemoteDataSource,
) : ContactsRepository {

    override fun postContact(
        type: String,
        title: String,
        content: String,
        email: String
    ): Single<Contacts> =
        remote.postContact(type, title, content, email)
            .map(ContactsMapper::mapToDomain)
}