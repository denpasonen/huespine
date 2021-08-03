package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.HashTagListMapper
import com.rightcode.huespine.data.mapper.HashTagMapper
import com.rightcode.huespine.data.source.remote.HashtagRemoteDataSource
import com.rightcode.huespine.domain.model.Hashtag
import com.rightcode.huespine.domain.repository.HashtagRepository
import io.reactivex.Single
import javax.inject.Inject

class HashtagRepositoryImpl @Inject constructor(
    private val remote: HashtagRemoteDataSource
) : HashtagRepository {

    override fun getHashtags(): Single<List<Hashtag>> {
        return remote.getHashtags()
            .map(HashTagListMapper::mapToDomain)
    }

    override fun getHashtag(id: Long): Single<Hashtag> {
        return remote.getHashtag(id)
            .map(HashTagMapper::mapToDomain)
    }
}