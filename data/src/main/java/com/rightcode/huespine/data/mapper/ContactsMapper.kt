package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.ContactsData
import com.rightcode.huespine.domain.model.Contacts


internal object ContactsMapper : Mapper<ContactsData, Contacts> {
    override fun mapToDomain(from: ContactsData): Contacts {
        return Contacts(
            id = from.id,
            status = from.status,
            email = from.email,
            content = from.content,
            answer = from.answer,
            answeredAt = from.answeredAt,
            createdAt = from.createdAt,
        )
    }
}