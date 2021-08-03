package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Banner
import com.rightcode.huespine.domain.repository.BannerRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BannerServiceImpl @Inject constructor(
    private val bannerRepository: BannerRepository
) : BannerService {

    override fun getHomeBanners(): Single<List<Banner>> {
        return bannerRepository.getBanners("home")
    }

    override fun getDiscoveryBanners(): Single<List<Banner>> {
        return bannerRepository.getBanners("discovery")
    }

    override fun getCoverBanners(): Single<List<Banner>> {
        return bannerRepository.getBanners("cover")
    }

    override fun saveNotShowToday(notShowToday: String): Completable {
        return bannerRepository.saveNotShowToday(notShowToday)
    }

    override fun getNotShowToday(): Single<String?> {
        return bannerRepository.getNotShowToday()
    }
}