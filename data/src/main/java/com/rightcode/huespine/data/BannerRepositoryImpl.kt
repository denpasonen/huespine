package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.BannerListMapper
import com.rightcode.huespine.data.source.local.BannerLocalDataSource
import com.rightcode.huespine.data.source.remote.BannerRemoteDataSource
import com.rightcode.huespine.domain.model.Banner
import com.rightcode.huespine.domain.repository.BannerRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(
    private val local: BannerLocalDataSource,
    private val remote: BannerRemoteDataSource
) : BannerRepository {
    override fun getBanners(type: String): Single<List<Banner>> {
        return remote.getBanners(type)
            .map(BannerListMapper::mapToDomain)
    }

    override fun saveNotShowToday(notShowToday: String): Completable {
        return local.save(notShowToday)
    }

    override fun getNotShowToday(): Single<String?> {
        return Single.just(local.notShowToday)
    }
}