package com.rightcode.huespine.local.naver

import android.content.Context
import com.rightcode.huespine.local.model.NaverAuthEntity
import com.nhn.android.naverlogin.OAuthLogin
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class NaverWrapperImpl @Inject constructor(
    context: Context,
    private val oauthLogin: OAuthLogin
) : NaverWrapper {
    private val applicationContext = context.applicationContext

    override fun getToken(): Single<NaverAuthEntity> {
        return Single.fromCallable {
            NaverAuthEntity(
                accessToken = oauthLogin.getAccessToken(applicationContext),
                refreshToken = oauthLogin.getRefreshToken(applicationContext)
            )
        }
    }

    override fun logout(): Completable {
        return Completable.fromCallable {
            oauthLogin.logout(applicationContext)
        }
    }
}