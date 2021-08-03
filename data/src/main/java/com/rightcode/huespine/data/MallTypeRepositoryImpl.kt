package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.MallTypeListMapper
import com.rightcode.huespine.data.mapper.MallTypeMapper
import com.rightcode.huespine.data.source.remote.MallTypeRemoteDataSource
import com.rightcode.huespine.domain.model.MallType
import com.rightcode.huespine.domain.repository.MallTypeRepository
import io.reactivex.Single
import javax.inject.Inject

class MallTypeRepositoryImpl @Inject constructor(
    private val remote: MallTypeRemoteDataSource
) : MallTypeRepository {

    override fun getMalltypes(): Single<List<MallType>> {
        return remote.getMallTypes()
            .map(MallTypeListMapper::mapToDomain)
    }

    override fun getMalltype(id: Long): Single<MallType> {
        return remote.getMallType(id)
            .map(MallTypeMapper::mapToDomain)
    }
}