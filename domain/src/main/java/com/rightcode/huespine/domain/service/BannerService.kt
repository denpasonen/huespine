package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Banner
import io.reactivex.Completable
import io.reactivex.Single

interface BannerService {

    fun getHomeBanners(): Single<List<Banner>>

    fun getDiscoveryBanners(): Single<List<Banner>>

    fun getCoverBanners(): Single<List<Banner>>

    fun saveNotShowToday(notShowToday: String): Completable

    fun getNotShowToday(): Single<String?>
}