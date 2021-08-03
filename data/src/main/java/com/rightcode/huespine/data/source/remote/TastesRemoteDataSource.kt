package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.TastesData
import io.reactivex.Single


interface TastesRemoteDataSource {
    fun getTastes(): Single<List<TastesData>>
}
