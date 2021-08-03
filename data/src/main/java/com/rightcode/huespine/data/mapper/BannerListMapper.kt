package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.BannerData
import com.rightcode.huespine.domain.model.Banner


internal object BannerListMapper :
    com.rightcode.huespine.data.mapper.Mapper<List<BannerData>, List<Banner>> {
    override fun mapToDomain(from: List<BannerData>): List<Banner> {
        return from.map { banner ->
            Banner(
                name = banner.name,
                image = banner.image,
                productIds = banner.productIds
            )
        }
    }
}