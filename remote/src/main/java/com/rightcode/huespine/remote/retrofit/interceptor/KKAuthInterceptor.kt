package com.rightcode.huespine.remote.retrofit.interceptor

import com.rightcode.huespine.data.provider.SessionProvider
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

internal class KKAuthInterceptor @Inject constructor(
    private val sessionProvider: SessionProvider
) : Interceptor {
    private val exception = IOException("NO AUTHORIZATION")


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val response = this.doRequest(chain)

        if (response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
            sessionProvider.logout()
            return response
        }

        response.headers(HEADER_RESPONSE_COOKIE).takeIf { it.isNotEmpty() }?.let { cookies ->
            val sid = cookies.first().substringBefore(";").substringAfter("=")
            sessionProvider.updateAccessToken(sid)
        }

        return response
    }

    @Throws(IOException::class)
    private fun doRequest(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val cookieSid = sessionProvider.cookieSid
        if (cookieSid != null) {
            return chain.proceed(
                request
                    .newBuilder()
                    .addHeader(HEADER_REQUEST_COOKIE, "$SID_PREFIX$cookieSid")
                    .build()
            )
        }
        return chain.proceed(request)
    }

    companion object {
        private const val HEADER_RESPONSE_COOKIE = "set-cookie"
        private const val HEADER_REQUEST_COOKIE = "Cookie"
        private const val SID_PREFIX = "kkooit.sid="
    }
}
