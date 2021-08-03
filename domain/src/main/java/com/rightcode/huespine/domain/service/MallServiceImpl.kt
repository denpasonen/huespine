package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Mall
import com.rightcode.huespine.domain.model.Product
import com.rightcode.huespine.domain.repository.MallRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MallServiceImpl @Inject constructor(
    private val mallRepository: MallRepository
) : MallService {

    override fun getMalls(start: Int, limit: Int): Single<List<Mall>> {
        return mallRepository.getMalls(start, limit)
    }

    override fun getMallsId(id: Long): Single<Mall> {
        return mallRepository.getMallsId(id)
    }

    override fun getMallsFilter(
        filter: String,
        start: Int,
        limit: Int
    ): Single<Pair<List<Mall>, Int>> {
        return mallRepository.getMallsFilter(filter, start, limit)
    }

    override fun getMallsIdProduct(
        id: Long,
        start: Int,
        perPage: Int
    ): Single<List<Product>> {
        return mallRepository.getMallsIdProduct(id, start, perPage)
    }

    override fun getMallsRankFilter(
        typeIds: Array<Long>?,
        hashtagIds: Array<Long>?
    ): Single<List<Mall>> {
        return mallRepository.getMallRankFilter(typeIds, hashtagIds)
    }

    override fun updateMallLike(id: Long, isLike: Boolean): Completable {
        return mallRepository.updateMallLike(id, isLike)
    }
}