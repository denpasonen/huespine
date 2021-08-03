package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.LikeList
import com.rightcode.huespine.domain.model.LikedUser
import com.rightcode.huespine.domain.model.UserProduct
import com.rightcode.huespine.domain.model.UserProductComment
import io.reactivex.Completable
import io.reactivex.Single

interface UserProductService {
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
        start: Int,
        perPage: Int,
    ): Single<List<UserProduct>>


    fun getUserProducts(
        userId: Long,
        start: Int,
        perPage: Int,
    ): Single<List<UserProduct>>

    fun getProductsByFilter(
        filter: List<String>? = null,
        search: String? = null,
        minPrice: Int? = null,
        maxPrice: Int? = null,
        sort: String? = null,
        order: String? = null,
        start: Int,
        perPage: Int,
    ): Single<Pair<List<UserProduct>, Int>>

    fun getMyProducts(
        start: Int,
        perPage: Int
    ): Single<Pair<List<UserProduct>, Int>>

    fun getProduct(id: Long): Single<UserProduct>

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
    ): Single<List<LikedUser>>

    fun getUserProductComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<UserProductComment>>

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
        parentId: Long? = null,
        content: String
    ): Completable

    fun deleteComment(
        id: Long
    ): Completable

    fun getUserProductLikeList(
        id: Long
    ): Single<List<LikeList>>

    fun addShareCount(
        id: Long
    ): Completable

}