package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Tastes
import io.reactivex.Single

interface TastesService {
    fun getTastes(): Single<List<Tastes>>
}