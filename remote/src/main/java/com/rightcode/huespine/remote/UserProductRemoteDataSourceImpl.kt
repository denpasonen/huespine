package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.LikeListData
import com.rightcode.huespine.data.model.LikedUserData
import com.rightcode.huespine.data.model.UserProductCommentData
import com.rightcode.huespine.data.model.UserProductData
import com.rightcode.huespine.data.source.remote.UserProductRemoteDataSource
import com.rightcode.huespine.remote.mapper.*
import com.rightcode.huespine.remote.model.request.CommentRequest
import com.rightcode.huespine.remote.model.request.UserProductRequest
import com.rightcode.huespine.remote.retrofit.api.UserProductApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class UserProductRemoteDataSourceImpl @Inject constructor(
    private val api: UserProductApi,
    private val gson: Gson
) : UserProductRemoteDataSource {
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
        return api.postUserProduct(
            body = UserProductRequest(
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
        ).catchRemoteError(gson)
    }

    override fun getProducts(
        search: String?,
        sort: String?,
        order: String?,
        start: Int,
        perPage: Int
    ): Single<List<UserProductData>> {
        return api.getUserProducts(
            search = search,
            sort = sort,
            order = order,
            start = start,
            perPage = perPage,
            maxPrice = null,
            minPrice = null,
            userId = null,
            filter = null
        ).map(GetUserProductListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getUserProducts(
        userId: Long,
        start: Int,
        perPage: Int
    ): Single<List<UserProductData>> {
        return api.getUserProducts(
            search = null,
            sort = null,
            order = null,
            start = start,
            perPage = perPage,
            maxPrice = null,
            minPrice = null,
            userId = userId,
            filter = null
        ).map(GetUserProductListMapper::mapToData)
            .catchRemoteError(gson)
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
    ): Single<Pair<List<UserProductData>, Int>> {
        return api.getUserProducts(
            filter = filter?.toTypedArray(),
            search = search,
            sort = sort,
            order = order,
            start = start,
            perPage = perPage,
            maxPrice = maxPrice,
            minPrice = minPrice,
            userId = null
        ).map { response ->
            GetUserProductListMapper.mapToData(response) to response.total
        }.catchRemoteError(gson)
    }

    override fun getMyProducts(
        userId: Long,
        start: Int,
        perPage: Int
    ): Single<Pair<List<UserProductData>, Int>> {
        return api.getUserProducts(
            filter = null,
            search = null,
            sort = "createdAt",
            order = "DESC",
            start = start,
            perPage = perPage,
            userId = userId,
            maxPrice = null,
            minPrice = null
        ).map { response ->
            GetUserProductListMapper.mapToData(response) to response.total
        }.catchRemoteError(gson)
    }

    override fun getProduct(id: Long): Single<UserProductData> {
        return api.getUserProduct(id)
            .map(GetUserProductMapper::mapToData)
            .catchRemoteError(gson)
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
        return api.putUserProductId(
            id = id,
            body = UserProductRequest(
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
        ).catchRemoteError(gson)
    }

    override fun deleteProduct(id: Long): Completable {
        return api.deleteUserProduct(id)
            .catchRemoteError(gson)
    }

    override fun getLikedUsers(id: Long): Single<List<LikedUserData>> {
        return api.getProductIdLike(id)
            .map(GetPostIdLikeMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getUserProductComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<UserProductCommentData>> {
        return api.getUserProductComments(
            id = id,
            start = start,
            perPage = limit,
            sort = "createdAt",
            order = "ASC"
        ).map(GetUserProductCommentListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun createComment(id: Long, parentId: Long?, content: String): Completable {
        return api.postUserProductComment(
            id = id,
            body = CommentRequest(parentId, content)
        ).catchRemoteError(gson)
    }

    override fun updateLike(id: Long, isLike: Boolean): Completable {
        return api.postProductIdLiked(id, isLike)
            .catchRemoteError(gson)
    }

    override fun updateCommentLike(id: Long, isLike: Boolean): Completable {
        return api.postProductCommentLike(id, isLike)
            .catchRemoteError(gson)
    }

    override fun updateComment(id: Long, parentId: Long?, content: String): Completable {
        return api.putProductComment(id = id, body = CommentRequest(parentId, content))
            .catchRemoteError(gson)
    }

    override fun deleteComment(id: Long): Completable {
        return api.deleteProductComment(id)
            .catchRemoteError(gson)
    }

    override fun getUserProductLikeList(id: Long): Single<List<LikeListData>> {
        return api.getUserProductLikeList(id)
            .map(GetUserProductLikeListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun addShareCount(id: Long): Completable {
        return api.postUserProductIdShared(id)
            .catchRemoteError(gson)
    }
}