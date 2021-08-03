package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Hashtag
import com.rightcode.huespine.domain.repository.HashtagRepository
import io.reactivex.Single
import javax.inject.Inject

class HashtagServiceImpl @Inject constructor(
    private val hashtagRepository: HashtagRepository
) : HashtagService {

    override fun getHashTags(): Single<List<Hashtag>> {
        return hashtagRepository.getHashtags()
    }

    override fun getHashtag(id: Long): Single<Hashtag> {
        return hashtagRepository.getHashtag(id)
    }
}