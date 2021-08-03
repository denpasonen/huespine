package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.MallType
import com.rightcode.huespine.domain.repository.MallTypeRepository
import io.reactivex.Single
import javax.inject.Inject

class MallTypeServiceImpl @Inject constructor(
    private val mallTypeRepository: MallTypeRepository
) : MallTypeService {

    override fun getMallTypes(): Single<List<MallType>> {
        return mallTypeRepository.getMalltypes()
    }

    override fun getMallType(id: Long): Single<MallType> {
        return mallTypeRepository.getMalltype(id)
    }
}