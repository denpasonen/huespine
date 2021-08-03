package com.rightcode.huespine.remote.utils.rx

import com.rightcode.huespine.data.exception.KKException
import com.rightcode.huespine.remote.model.response.ErrorResponse
import com.google.gson.Gson
import io.reactivex.Single
import retrofit2.HttpException

internal fun <T> Single<T>.catchRemoteError(): Single<T> {
    return this.onErrorResumeNext { throwable: Throwable ->
        if (throwable is HttpException) {
            val errorBody = throwable.response()?.errorBody()?.string()
            Single.error(KKException(errorBody ?: "", throwable, throwable.code()))
        } else {
            Single.error(throwable)
        }
    }
}

internal fun <T> Single<T>.catchRemoteError(gson: Gson): Single<T> {
    return this.onErrorResumeNext { throwable: Throwable ->
        if (throwable is HttpException) {
            val errorJson = throwable.response()?.errorBody()?.string()?.let { errorJson ->
                gson.fromJson(errorJson, ErrorResponse::class.java)
            }
            Single.error(KKException(errorJson?.message ?: "", throwable, throwable.code()))
        } else {
            Single.error(throwable)
        }
    }
}
