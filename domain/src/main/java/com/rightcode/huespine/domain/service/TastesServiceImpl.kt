package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Tastes
import com.rightcode.huespine.domain.repository.TastesRepository
import io.reactivex.Single
import javax.inject.Inject

class TastesServiceImpl @Inject constructor(
    private val tastesRepository: TastesRepository
) : TastesService {
    override fun getTastes(): Single<List<Tastes>> = tastesRepository.getTastes()
}