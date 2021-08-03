package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.BannerData
import com.rightcode.huespine.remote.model.response.GetBannerResponse

internal object GetBannerListMapper : Mapper<List<GetBannerResponse>, List<BannerData>> {
    override fun mapToData(from: List<GetBannerResponse>): List<BannerData> {
        return from.map { banner ->
            BannerData(
                name = banner.name,
                image = banner.image,
                productIds = banner.productIds
            )
        }
    }
}