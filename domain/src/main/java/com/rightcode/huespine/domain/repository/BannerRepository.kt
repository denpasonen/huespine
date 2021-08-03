package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.Banner
import io.reactivex.Completable
import io.reactivex.Single

interface BannerRepository {
    fun getBanners(type: String): Single<List<Banner>>

    fun saveNotShowToday(notShowToday: String): Completable

    fun getNotShowToday(): Single<String?>
}