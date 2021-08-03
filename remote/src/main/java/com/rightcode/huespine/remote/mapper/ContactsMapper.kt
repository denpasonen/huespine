package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.ContactsData
import com.rightcode.huespine.remote.model.response.ContactsResponse

internal object ContactsMapper : Mapper<ContactsResponse, ContactsData> {
    override fun mapToData(from: ContactsResponse): ContactsData {
        return ContactsData(
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