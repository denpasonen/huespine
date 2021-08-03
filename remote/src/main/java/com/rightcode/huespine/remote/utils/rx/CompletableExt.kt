package com.rightcode.huespine.remote.utils.rx

import com.rightcode.huespine.data.exception.KKException
import com.rightcode.huespine.remote.model.response.ErrorResponse
import com.google.gson.Gson
import io.reactivex.Completable
import retrofit2.HttpException

internal fun Completable.catchRemoteError(): Completable {
    return this.onErrorResumeNext { throwable: Throwable ->
        if (throwable is HttpException) {
            val errorBody = throwable.response()?.errorBody()?.string()
            Completable.error(KKException(errorBody ?: "", throwable, throwable.code()))
        } else {
            Completable.error(throwable)
        }
    }
}

internal fun Completable.catchRemoteError(gson: Gson): Completable {
    return this.onErrorResumeNext { throwable: Throwable ->
        if (throwable is HttpException) {
            val errorJson = throwable.response()?.errorBody()?.string()?.let { errorJson ->
                gson.fromJson(errorJson, ErrorResponse::class.java)
            }
            Completable.error(KKException(errorJson?.message ?: "", throwable, throwable.code()))
        } else {
            Completable.error(throwable)
        }
    }
}