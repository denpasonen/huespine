package com.rightcode.huespine.domain.repository


import com.rightcode.huespine.domain.model.Tastes
import io.reactivex.Single

interface TastesRepository {
    fun getTastes(): Single<List<Tastes>>
}