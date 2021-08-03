package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.MallType
import io.reactivex.Single

interface MallTypeRepository {
    fun getMalltypes(
    ): Single<List<MallType>>

    fun getMalltype(
        id: Long,
    ): Single<MallType>
}