package com.rightcode.huespine.remote.retrofit.interceptor

import com.rightcode.huespine.remote.provider.ConnectionProvider
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

internal class ConnectionInterceptor @Inject constructor(
    private val connectionProvider: ConnectionProvider
) : Interceptor {
    private val exception = IOException("Please check your internet connection and retry")

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (connectionProvider.isReachable) {
            try {
                return chain.proceed(chain.request())
            } catch (e: IOException) {
                if (isConnectionError(e)) {
                    throw exception
                } else {
                    throw e
                }
            }
        } else {
            throw exception
        }
    }

    private fun isConnectionError(exception: IOException): Boolean {
        return exception is SocketTimeoutException
                || exception is ConnectException
                || exception is UnknownHostException
    }
}