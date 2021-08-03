package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.KeywordData
import io.reactivex.Completable
import io.reactivex.Single


interface KeywordRemoteDataSource {

    fun getKeywords(
    ): Single<List<KeywordData>>

//    fun getKeywordId(
//        id: Long,
//    ): Single<KeywordData>

    fun postKeywordLog(
        keyword: String
    ): Completable
}
