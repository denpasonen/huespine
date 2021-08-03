package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.TastesListMapper
import com.rightcode.huespine.data.source.remote.TastesRemoteDataSource
import com.rightcode.huespine.domain.model.Tastes
import com.rightcode.huespine.domain.repository.TastesRepository
import io.reactivex.Single
import javax.inject.Inject

class TastesRepositoryImpl @Inject constructor(
    private val remote: TastesRemoteDataSource,
) : TastesRepository {
    override fun getTastes(): Single<List<Tastes>> = remote.getTastes()
        .map(TastesListMapper::mapToDomain)
}