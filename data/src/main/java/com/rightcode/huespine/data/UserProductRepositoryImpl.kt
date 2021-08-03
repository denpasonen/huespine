package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.*
import com.rightcode.huespine.data.source.remote.UserProductRemoteDataSource
import com.rightcode.huespine.domain.model.LikeList
import com.rightcode.huespine.domain.model.LikedUser
import com.rightcode.huespine.domain.model.UserProduct
import com.rightcode.huespine.domain.model.UserProductComment
import com.rightcode.huespine.domain.repository.UserProductRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserProductRepositoryImpl @Inject constructor(
    private val remote: UserProductRemoteDataSource
) : UserProductRepository {
    override fun createProduct(
        type: String,
        dealType: List<String>,
        title: String,
        description: String,
        images: List<String>,
        price: Int?,
        endAt: String?,
        status: String?,
        freeShipping: Boolean
    ): Completable {
        return remote.createProduct(
            type,
            dealType,
            title,
            description,
            images,
            price,
            endAt,
            status,
            freeShipping
        )
    }

    override fun getProducts(
        search: String?,
        sort: String?,
        order: String?,
        start: Int,
        perPage: Int
    ): Single<List<UserProduct>> {
        return remote.getProducts(search, sort, order, start, perPage)
            .map(UserProductListMapper::mapToDomain)
    }

    override fun getUserProducts(
        userId: Long,
        start: Int,
        perPage: Int
    ): Single<List<UserProduct>> {
        return remote.getUserProducts(userId, start, perPage)
            .map(UserProductListMapper::mapToDomain)
    }

    override fun getMyProducts(
        userId: Long,
        start: Int,
        perPage: Int
    ): Single<Pair<List<UserProduct>, Int>> {
        return remote.getMyProducts(userId, start, perPage)
            .map { (list, total) ->
                UserProductListMapper.mapToDomain(list) to total
            }
    }

    override fun getProduct(id: Long): Single<UserProduct> {
        return remote.getProduct(id)
            .map(UserProductMapper::mapToDomain)
    }


    override fun getProductsByFilter(
        filter: List<String>?,
        search: String?,
        minPrice: Int?,
        maxPrice: Int?,
        sort: String?,
        order: String?,
        start: Int,
        perPage: Int
    ): Single<Pair<List<UserProduct>, Int>> {
        return remote.getProductsByFilter(
            filter,
            search,
            minPrice,
            maxPrice,
            sort,
            order,
            start,
            perPage
        ).map { (list, total) ->
            UserProductListMapper.mapToDomain(list) to total
        }
    }

    override fun updateProduct(
        id: Long,
        type: String,
        dealType: List<String>,
        title: String,
        description: String,
        images: List<String>,
        price: Int?,
        endAt: String?,
        status: String?,
        freeShipping: Boolean
    ): Completable {
        return remote.updateProduct(
            id,
            type,
            dealType,
            title,
            description,
            images,
            price,
            endAt,
            status,
            freeShipping
        )
    }

    override fun deleteProduct(id: Long): Completable {
        return remote.deleteProduct(id)
    }

    override fun getLikedUsers(id: Long): Single<List<LikedUser>> {
        return remote.getLikedUsers(id)
            .map(LikedUserListMapper::mapToDomain)
    }

    override fun getUserProductComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<UserProductComment>> {
        return remote.getUserProductComments(id, start, limit)
            .map(UserProductCommentListMapper::mapToDomain)
    }

    override fun createComment(id: Long, parentId: Long?, content: String): Completable {
        return remote.createComment(id, parentId, content)
    }

    override fun updateLike(id: Long, isLike: Boolean): Completable {
        return remote.updateLike(id, isLike)
    }

    override fun updateCommentLike(id: Long, isLike: Boolean): Completable {
        return remote.updateCommentLike(id, isLike)
    }

    override fun updateComment(id: Long, parentId: Long?, content: String): Completable {
        return remote.updateComment(id, parentId, content)
    }

    override fun deleteComment(id: Long): Completable {
        return remote.deleteComment(id)
    }

    override fun getUserProductLikeList(id: Long): Single<List<LikeList>> {
        return remote.getUserProductLikeList(id).map(LikeListMapper::mapToDomain)
    }

    override fun addShareCount(id: Long): Completable {
        return remote.addShareCount(id)
    }
}