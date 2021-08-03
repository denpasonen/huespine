package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Keyword
import io.reactivex.Completable
import io.reactivex.Single

interface KeywordService {
    fun getKeywords(
    ): Single<List<Keyword>>

    fun postKeywordLog(
        keyword: String
    ): Completable
}