package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.Hashtag
import io.reactivex.Single

interface HashtagRepository {
    fun getHashtags(
    ): Single<List<Hashtag>>

    fun getHashtag(
        id: Long,
    ): Single<Hashtag>

}