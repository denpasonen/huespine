package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.HashtagData
import io.reactivex.Single


interface HashtagRemoteDataSource {

    fun getHashtags(
    ): Single<List<HashtagData>>

    fun getHashtag(
        id: Long,
    ): Single<HashtagData>
}
