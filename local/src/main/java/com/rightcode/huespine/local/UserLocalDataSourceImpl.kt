package com.rightcode.huespine.local

import com.rightcode.huespine.data.model.UserData
import com.rightcode.huespine.data.source.local.UserLocalDataSource
import com.rightcode.huespine.local.mapper.UserMapper
import com.rightcode.huespine.local.preferences.SessionPref
import com.rightcode.huespine.local.room.dao.UserDao
import com.rightcode.huespine.local.utils.optionalize
import com.rightcode.huespine.local.utils.rx.ext.mapToDataError
import com.rightcode.huespine.local.utils.rx.schedulers.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject


internal class UserLocalDataSourceImpl @Inject constructor(
    private val userPref: SessionPref,
    private val userDao: UserDao,
    private val schedulerProvider: SchedulerProvider
) : UserLocalDataSource {
    override fun getCurrentUser(): Flowable<Optional<UserData>> {
        return if (userPref.currentUserId != null && userPref.currentUserId != 0L) {
            userDao.findOneBy(userPref.currentUserId ?: 0)
                .map(UserMapper::mapToData)
                .subscribeOn(schedulerProvider.io)
                .optionalize()
        } else {
            Flowable.just(Optional.empty())
        }
        /*  return userDao.existsById(userPref.currentUserId ?: 0)
              .subscribeOn(schedulerProvider.io)
              .flatMapPublisher { exist ->
                  Flowable.defer {
                      if (exist) {
                          userDao.findOneBy(userPref.currentUserId ?: 0)
                              .map(UserMapper::mapToData)
                              .optionalize()
                      } else {
                          Flowable.just(Optional.empty())
                      }
                  }
              }.mapToDataError()*/

        /*Single.fromCallable { userPref.currentUserId }
            .flatMapPublisher(userDao::findOneBy)
            .map(UserMapper::mapToData)
            .subscribeOn(schedulerProvider.io)
            .mapToDataError()*/
    }

    override fun getUser(userId: Long): Single<UserData> {
        return userDao.findOneByIdOnce(userId)
            .subscribeOn(schedulerProvider.io)
            .map(UserMapper::mapToData)
            .mapToDataError()
    }

    override fun save(user: UserData): Completable {
        return Single.just(user)
            .map(UserMapper::mapToLocal)
            .flatMap(userDao::insert)
            .doOnSuccess { userId -> userPref.currentUserId = userId }
            .ignoreElement()
            .subscribeOn(schedulerProvider.io)
            .mapToDataError()
    }
}