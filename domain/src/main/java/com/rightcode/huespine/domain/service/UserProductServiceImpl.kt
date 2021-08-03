package com.rightcode.huespine.domain.service

import android.webkit.URLUtil
import com.rightcode.huespine.domain.model.LikeList
import com.rightcode.huespine.domain.model.LikedUser
import com.rightcode.huespine.domain.model.UserProduct
import com.rightcode.huespine.domain.model.UserProductComment
import com.rightcode.huespine.domain.repository.FileRepository
import com.rightcode.huespine.domain.repository.UserProductRepository
import com.rightcode.huespine.domain.repository.UserRepository
import com.rightcode.huespine.domain.util.getOrNull
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.internal.operators.completable.CompletableDefer
import javax.inject.Inject

class UserProductServiceImpl @Inject constructor(
    private val productRepository: UserProductRepository,
    private val fileRepository: FileRepository,
    private val userRepository: UserRepository
) : UserProductService {
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
        return CompletableDefer {

            if (images.isNotEmpty()) {
                val uploadedImages = Flowable.fromIterable(images)
                    .concatMapEager { imagePath ->
                        fileRepository.uploadPictureImage(imagePath)
                            .toFlowable()
                    }.toList()

                uploadedImages.flatMapCompletable { uris ->
                    productRepository.createProduct(
                        type,
                        dealType,
                        title,
                        description,
                        uris,
                        price,
                        endAt,
                        status,
                        freeShipping
                    )
                }
            } else {
                productRepository.createProduct(
                    type,
                    dealType,
                    title,
                    description,
                    emptyList(),
                    price,
                    endAt,
                    status,
                    freeShipping
                )
            }
        }
    }

    override fun getProducts(
        start: Int,
        perPage: Int
    ): Single<List<UserProduct>> {
        return productRepository.getProducts(null, null, null, start, perPage)
    }

    override fun getUserProducts(
        userId: Long,
        start: Int,
        perPage: Int
    ): Single<List<UserProduct>> {
        return productRepository.getUserProducts(userId, start, perPage)
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
        return productRepository.getProductsByFilter(
            filter,
            search,
            minPrice,
            maxPrice,
            sort,
            order,
            start,
            perPage
        )
    }

    override fun getMyProducts(
        start: Int,
        perPage: Int
    ): Single<Pair<List<UserProduct>, Int>> {
        return userRepository.fetchUser()
            .firstOrError()
            .flatMap { user ->
                productRepository.getMyProducts(user.getOrNull()?.id ?: 0L, start, perPage)
            }
    }

    override fun getProduct(id: Long): Single<UserProduct> {
        return productRepository.getProduct(id)
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

        return CompletableDefer {
            val preUploadedImages = images.filter { url ->
                URLUtil.isHttpsUrl(url)
            }

            val needUploadedImages = images.filterNot { url ->
                URLUtil.isHttpsUrl(url)
            }

            val uploadedImages = Flowable.fromIterable(needUploadedImages)
                .concatMapEager { url ->
                    fileRepository.uploadPictureImage(url)
                        .toFlowable()
                }.toList()

            uploadedImages.flatMapCompletable { uris ->

                val checkedImages =
                    if ((preUploadedImages + uris).isNotEmpty()) preUploadedImages + uris else emptyList()

                productRepository.updateProduct(
                    id = id,
                    type = type,
                    dealType = dealType,
                    title = title,
                    description = description,
                    images = checkedImages,
                    price = price,
                    endAt = endAt,
                    status = status,
                    freeShipping = freeShipping
                )
            }
        }

    }

    override fun deleteProduct(id: Long): Completable {
        return productRepository.deleteProduct(id)
    }

    override fun getLikedUsers(id: Long): Single<List<LikedUser>> {
        return productRepository.getLikedUsers(id)
    }

    override fun getUserProductComments(
        id: Long,
        start: Int,
        limit: Int
    ): Single<List<UserProductComment>> {
        return userRepository.fetchUser()
            .firstOrError()
            .flatMap { user ->
                productRepository.getUserProductComments(id, start, limit)
                    .map { comments ->
                        comments.map { comment ->
                            if (user.getOrNull()?.id == comment.userId) {
                                comment.copy(isMine = true)
                            } else {
                                comment
                            }
                        }
                    }
            }
    }

    override fun createComment(id: Long, parentId: Long?, content: String): Completable {
        return productRepository.createComment(id, parentId, content)
    }

    override fun updateLike(id: Long, isLike: Boolean): Completable {
        return productRepository.updateLike(id, isLike)
    }

    override fun updateCommentLike(id: Long, isLike: Boolean): Completable {
        return productRepository.updateCommentLike(id, isLike)
    }

    override fun updateComment(id: Long, parentId: Long?, content: String): Completable {
        return productRepository.updateComment(id, parentId, content)
    }

    override fun deleteComment(id: Long): Completable {
        return productRepository.deleteComment(id)
    }

    override fun getUserProductLikeList(id: Long): Single<List<LikeList>> {
        return productRepository.getUserProductLikeList(id)
    }

    override fun addShareCount(id: Long): Completable {
        return productRepository.addShareCount(id)
    }
}