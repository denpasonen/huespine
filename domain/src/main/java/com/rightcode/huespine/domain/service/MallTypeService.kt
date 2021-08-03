package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.MallType
import io.reactivex.Single

interface MallTypeService {
    fun getMallTypes(
    ): Single<List<MallType>>

    fun getMallType(
        id: Long
    ): Single<MallType>
}