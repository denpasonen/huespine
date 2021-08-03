package com.rightcode.huespine.domain.service

import android.webkit.URLUtil
import com.rightcode.huespine.domain.model.LikeList
import com.rightcode.huespine.domain.model.LikedUser
import com.rightcode.huespine.domain.model.Post
import com.rightcode.huespine.domain.model.PostComment
import com.rightcode.huespine.domain.repository.FileRepository
import com.rightcode.huespine.domain.repository.PostRepository
import com.rightcode.huespine.domain.repository.UserRepository
import com.rightcode.huespine.domain.util.getOrNull
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.internal.operators.completable.CompletableDefer
import javax.inject.Inject

class PostServiceImpl @Inject constructor(
    private val postRepository: PostRepository,
    private val fileRepository: FileRepository,
    private val userRepository: UserRepository
) : PostService {

    override fun getPostList(type: String?, start: Int, limit: Int): Single<List<Post>> {
        return postRepository.getPostList(type, start, limit)
    }

    override fun getUserPostList(
        type: String?,
        userId: Long,
        start: Int,
        limit: Int
    ): Single<List<Post>> {
        return postRepository.getUserPostList(type, userId, start, limit)
    }

    override fun getPostListByFilter(
        type: String?,
        search: String,
        sort: String,
        order: String,
        start: Int,
        limit: Int
    ): Single<List<Post>> {
        return postRepository.getPostListByFilter(type, search, sort, order, start, limit)
    }

    override fun getMyPostList(
        start: Int,
        limit: Int
    ): Single<Pair<List<Post>, Int>> {

        return userRepository.fetchUser()
            .firstOrError()
            .flatMap { user ->
                postRepository.getMyPostList(user.getOrNull()?.id ?: 0L, start, limit)
            }
    }

    override fun getPost(id: Long): Single<Post> {
        return postRepository.getPost(id)
    }

    override fun getPopularityPosts(
        start: Int,
        limit: Int
    ): Single<List<Post>> {
        return postRepository.getPopularityPosts(start, limit)
    }

    override fun createPost(type: String, images: List<String>, description: String): Completable {
        return CompletableDefer {

            if (images.isNotEmpty()) {
                val uploadedImages = Flowable.fromIterable(images)
                    .concatMapEager { imagePath ->
                        fileRepository.uploadPictureImage(imagePath)
                            .toFlowable()
                    }.toList()

                uploadedImages
                    .flatMapCompletable { uris ->
                        postRepository.createPost(type, uris, description)
                    }
            } else {
                postRepository.createPost(type, emptyList(), description)
            }

        }
    }

    override fun updatePost(
        id: Long,
        type: String,
        images: List<String>,
        description: String
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

                postRepository.updatePost(
                    id = id,
                    type = type,
                    description = description,
                    images = checkedImages
                )
            }
        }
    }

    override fun updatePostLike(id: Long, isLike: Boolean): Completable {
        return postRepository.updatePostLike(id, isLike)
    }

    override fun deletePost(id: Long): Completable {
        return postRepository.deletePost(id)
    }

    override fun reportPost(id: Long): Completable {
        return postRepository.reportPost(id)
    }

    override fun getLikedUsers(id: Long): Single<List<LikedUser>> {
        return postRepository.getLikedUsers(id)
    }

    override fun getPostComments(id: Long, start: Int, limit: Int): Single<List<PostComment>> {
        return userRepository.fetchUser()
            .firstOrError()
            .flatMap { user ->
                postRepository.getPostComments(id, start, limit)
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
        return postRepository.createComment(id, parentId, content)
    }

    override fun updateCommentLike(id: Long, isLike: Boolean): Completable {
        return postRepository.updateCommentLike(id, isLike)
    }

    override fun updateComment(id: Long, parentId: Long?, content: String): Completable {
        return postRepository.updateComment(id, parentId, content)
    }

    override fun deleteComment(id: Long): Completable {
        return postRepository.deleteComment(id)
    }

    override fun reportComment(id: Long): Completable {
        return postRepository.reportComment(id)
    }

    override fun getPostLikeList(id: Long): Single<List<LikeList>> {
        return postRepository.getPostLikeList(id)
    }

    override fun getSearchList(): Single<Set<String>> {
        return postRepository.getSearchList()
    }

    override fun addShareCount(id: Long): Completable {
        return postRepository.addShareCount(id)
    }
}