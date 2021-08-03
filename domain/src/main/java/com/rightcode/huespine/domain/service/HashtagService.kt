package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Hashtag
import io.reactivex.Single

interface HashtagService {
    fun getHashTags(
    ): Single<List<Hashtag>>

    fun getHashtag(
        id: Long
    ): Single<Hashtag>
}