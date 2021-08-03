package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.KeywordData
import com.rightcode.huespine.data.source.remote.KeywordRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetKeywordListMapper
import com.rightcode.huespine.remote.retrofit.api.KeywordApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class KeywordRemoteDataSourceImpl @Inject constructor(
    private val api: KeywordApi,
    private val gson: Gson
) : KeywordRemoteDataSource {

    override fun getKeywords(): Single<List<KeywordData>> {
        return api.getKeywords().map(GetKeywordListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun postKeywordLog(keyword: String): Completable {
        return api.postKeywordLog(keyword)
            .catchRemoteError(gson)
    }
}