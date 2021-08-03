package com.rightcode.huespine.remote

import com.rightcode.huespine.data.source.remote.TastesRemoteDataSource
import com.rightcode.huespine.remote.mapper.TastesListMapper
import com.rightcode.huespine.remote.retrofit.api.TastesApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import javax.inject.Inject

internal class TastesRemoteDataSourceImpl @Inject constructor(
    private val api: TastesApi,
    private val gson: Gson
) : TastesRemoteDataSource {

    override fun getTastes() = api.getTastes()
        .map(TastesListMapper::mapToData)
        .catchRemoteError(gson)

}