package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.MallListMapper
import com.rightcode.huespine.data.mapper.MallMapper
import com.rightcode.huespine.data.mapper.ProductListMapper
import com.rightcode.huespine.data.source.remote.MallRemoteDataSource
import com.rightcode.huespine.domain.model.Mall
import com.rightcode.huespine.domain.model.Product
import com.rightcode.huespine.domain.repository.MallRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MallRepositoryImpl @Inject constructor(
    private val remote: MallRemoteDataSource
) : MallRepository {

    override fun getMalls(start: Int, limit: Int): Single<List<Mall>> {
        return remote.getMall(start, limit)
            .map(MallListMapper::mapToDomain)
    }

    override fun getMallsId(id: Long): Single<Mall> {
        return remote.getMallsId(id)
            .map(MallMapper::mapToDomain)
    }

    override fun getMallsFilter(
        filter: String,
        start: Int,
        limit: Int
    ): Single<Pair<List<Mall>, Int>> {
        return remote.getMallsFilter(filter, start, limit)
            .map { (list, total) ->
                MallListMapper.mapToDomain(list) to total
            }
    }

    override fun getMallsIdProduct(
        id: Long,
        start: Int,
        perPage: Int
    ): Single<List<Product>> {
        return remote.getMallsIdProduct(id, start, perPage)
            .map(ProductListMapper::mapToDomain)
    }

    override fun getMallRankFilter(
        typeIds: Array<Long>?,
        hashtagIds: Array<Long>?
    ): Single<List<Mall>> {
        return remote.getMallRankFilter(typeIds, hashtagIds)
            .map(MallListMapper::mapToDomain)
    }

    override fun updateMallLike(id: Long, isLike: Boolean): Completable {
        return remote.updateMallLike(id, isLike)
    }
}