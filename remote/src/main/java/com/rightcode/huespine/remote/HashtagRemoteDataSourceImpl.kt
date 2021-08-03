package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.HashtagData
import com.rightcode.huespine.data.source.remote.HashtagRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetHashtagListMapper
import com.rightcode.huespine.remote.mapper.GetHashtagMapper
import com.rightcode.huespine.remote.retrofit.api.HashtagApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

internal class HashtagRemoteDataSourceImpl @Inject constructor(
    private val api: HashtagApi,
    private val gson: Gson
) : HashtagRemoteDataSource {


    override fun getHashtags(): Single<List<HashtagData>> {
        return api.getHashtags(
            search = null,
            start = 0,
            perPage = 30
        ).map(GetHashtagListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getHashtag(id: Long): Single<HashtagData> {
        return api.getHashtag(id)
            .map(GetHashtagMapper::mapToData)
            .catchRemoteError(gson)
    }
}