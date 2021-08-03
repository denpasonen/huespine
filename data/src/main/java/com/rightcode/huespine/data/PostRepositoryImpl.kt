package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.*
import com.rightcode.huespine.data.source.local.SearchLocalDataSource
import com.rightcode.huespine.data.source.remote.PostRemoteDataSource
import com.rightcode.huespine.domain.model.LikeList
import com.rightcode.huespine.domain.model.LikedUser
import com.rightcode.huespine.domain.model.Post
import com.rightcode.huespine.domain.model.PostComment
import com.rightcode.huespine.domain.repository.PostRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val local: SearchLocalDataSource,
    private val remote: PostRemoteDataSource
) : PostRepository {
    override fun getPostList(type: String?, start: Int, limit: Int): Single<List<Post>> {
        return remote.getPostList(type, start, limit)
            .map(PostListMapper::mapToDomain)
    }

    override fun getUserPostList(
        type: String?,
        userId: Long,
        start: Int,
        limit: Int
    ): Single<List<Post>> {
        return remote.getUserPostList(type, userId, start, limit)
            .map(PostListMapper::mapToDomain)
    }

    override fun getPostListByFilter(
        type: String?,
        search: String,
        sort: String,
        order: String,
        start: Int,
        limit: Int
    ): Single<List<Post>> {
        return local.save(search)
            //FIXME
            .doOnComplete {
                remote.postKeywordLogs(search)
                    .subscribe()
            }
            .andThen(
                remote.getPostListByFilter(
                    type, search, sort, order, start, limit
                ).map(PostListMapper::mapToDomain)
            )
    }

    override fun getMyPostList(
        userId: Long,
        start: Int,
        limit: Int
    ): Single<Pair<List<Post>, Int>> {
        return remote.getMyPostList(
            userId, start, limit
        ).map { (list, total) ->
            PostListMapper.mapToDomain(list) to total
        }
    }

    override fun getPost(id: Long): Single<Post> {
        return remote.getPost(id)
            .map(PostMapper::mapToDomain)
    }

    override fun getPopularityPosts(
        start: Int,
        limit: Int
    ): Single<List<Post>> {
        return remote.getPopularityPosts(start, limit)
            .map(PostListMapper::mapToDomain)
    }

    override fun createPost(type: String, images: List<String>, description: String): Completable {
        return remote.createPost(type, images, description)
    }

    override fun updatePost(
        id: Long,
        type: String,
        images: List<String>,
        description: String
    ): Completable {
        return remote.updatePost(id, type, images, description)
    }

    override fun deletePost(id: Long): Completable {
        return remote.deletePost(id)
    }

    override fun reportPost(id: Long): Completable {
        return remote.reportPost(id)
    }

    override fun getLikedUsers(id: Long): Single<List<LikedUser>> {
        return remote.getLikedUsers(id)
            .map(LikedUserListMapper::mapToDomain)
    }

    override fun updatePostLike(id: Long, isLike: Boolean): Completable {
        return remote.updatePostLike(id, isLike)
    }

    override fun getPostComments(id: Long, start: Int, limit: Int): Single<List<PostComment>> {
        return remote.getPostComments(id, start, limit)
            .map(PostCommentListMapper::mapToDomain)
    }

    override fun createComment(id: Long, parentId: Long?, content: String): Completable {
        return remote.createComment(id, parentId, content)
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

    override fun reportComment(id: Long): Completable {
        return remote.reportPost(id)
    }

    override fun getPostLikeList(id: Long): Single<List<LikeList>> {
        return remote.getPostLikeList(id)
            .map(LikeListMapper::mapToDomain)
    }

    override fun getSearchList(): Single<Set<String>> {
        return Single.just(local.searchList)
    }

    override fun addShareCount(id: Long): Completable {
        return remote.addShareCount(id)
    }
}