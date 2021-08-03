package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.KeywordListMapper
import com.rightcode.huespine.data.source.remote.KeywordRemoteDataSource
import com.rightcode.huespine.domain.model.Keyword
import com.rightcode.huespine.domain.repository.KeywordRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class KeywordRepositoryImpl @Inject constructor(
    private val remote: KeywordRemoteDataSource
) : KeywordRepository {

    override fun getKeywords(): Single<List<Keyword>> {
        return remote.getKeywords()
            .map(KeywordListMapper::mapToDomain)
    }

    override fun postKeywordLog(keyword: String): Completable {
        return remote.postKeywordLog(keyword)
    }
}