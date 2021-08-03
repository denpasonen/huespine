package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.Keyword
import io.reactivex.Completable
import io.reactivex.Single

interface KeywordRepository {
    fun getKeywords(
    ): Single<List<Keyword>>

//    fun getKeywordId(
//        id: Long
//    ): Single<Keyword>

    fun postKeywordLog(
        keyword: String
    ): Completable
}