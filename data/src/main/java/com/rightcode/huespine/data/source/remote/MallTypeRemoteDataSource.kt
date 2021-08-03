package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.MallTypeData
import io.reactivex.Single


interface MallTypeRemoteDataSource {

    fun getMallTypes(
    ): Single<List<MallTypeData>>

    fun getMallType(
        id: Long,
    ): Single<MallTypeData>
}
