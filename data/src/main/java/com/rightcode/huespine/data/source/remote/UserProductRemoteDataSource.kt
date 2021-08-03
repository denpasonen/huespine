package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.LikeListData
import com.rightcode.huespine.data.model.LikedUserData
import com.rightcode.huespine.data.model.UserProductCommentData
import com.rightcode.huespine.data.model.UserProductData
import io.reactivex.Completable
import io.reactivex.Single


interface UserProductRemoteDataSource {

    fun createProduct(
        type: String,
        dealType: List<String>,
        title: String,
        description: String,
        images: List<String>,
        price: Int?,
        endAt: String?,
        status: String?,
        freeShipping: Boolean
    ): Completable

    fun getProducts(
        search: String?,
        sort: String?,
        order: String?,
        start: Int,
        perPage: Int
    ): Single<List<UserProductData>>


    fun getUserProducts(
        userId: Long,
        start: Int,
        perPage: Int
    ): Single<List<UserProductData>>

    fun getProductsByFilter(
        filter: List<String>?,
        search: String?,
        minPrice: Int?,
        maxPrice: Int?,
        sort: String?,
        order: String?,
        start: Int,
        perPage: Int
    ): Single<Pair<List<UserProductData>, Int>>

    fun getMyProducts(
        userId: Long,
        start: Int,
        perPage: Int
    ): Single<Pair<List<UserProductData>, Int>>

    fun getProduct(id: Long): Single<UserProductData>

    fun updateProduct(
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
    ): Completable

    fun updateLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun deleteProduct(
        id: Long
    ): Completable

    fun getLikedUsers(
        id: Long
    ): Single<List<LikedUserData>>

    fun getUserProductComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<UserProductCommentData>>

    fun createComment(
        id: Long,
        parentId: Long?,
        content: String
    ): Completable

    fun updateCommentLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun updateComment(
        id: Long,
        parentId: Long?,
        content: String
    ): Completable

    fun deleteComment(
        id: Long
    ): Completable

    fun getUserProductLikeList(
        id: Long
    ): Single<List<LikeListData>>

    fun addShareCount(
        id: Long
    ): Completable

}
