package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.MallTypeData
import com.rightcode.huespine.data.source.remote.MallTypeRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetMallTypeListMapper
import com.rightcode.huespine.remote.mapper.GetMallTypeMapper
import com.rightcode.huespine.remote.retrofit.api.MallTypeApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

internal class MallTypeRemoteDataSourceImpl @Inject constructor(
    private val api: MallTypeApi,
    private val gson: Gson
) : MallTypeRemoteDataSource {

    override fun getMallTypes(): Single<List<MallTypeData>> {
        return api.getMallTypes(
            search = null,
            start = 0,
            perPage = 30
        ).map(GetMallTypeListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getMallType(id: Long): Single<MallTypeData> {
        return api.getMallType(id)
            .map(GetMallTypeMapper::mapToData)
            .catchRemoteError(gson)
    }
}