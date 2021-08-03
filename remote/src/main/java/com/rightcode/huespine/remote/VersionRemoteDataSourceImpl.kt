package com.rightcode.huespine.remote

import com.rightcode.huespine.data.source.remote.VersionRemoteDataSource
import com.rightcode.huespine.remote.utils.rx.schedulers.SchedulerProvider
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.install.model.UpdateAvailability
import io.reactivex.Single
import org.jsoup.Jsoup
import javax.inject.Inject


internal class VersionRemoteDataSourceImpl @Inject constructor(
    private val appUpdateManager: AppUpdateManager,
    private val schedulerProvider: SchedulerProvider
) : VersionRemoteDataSource {
    override fun getVersionName(packageName: String): Single<String> {
        return getVersionNameFormGooglePlay(packageName)
            .subscribeOn(schedulerProvider.io)
    }

    private fun AppUpdateManager.appUpdateInfoResult(): Single<AppUpdateInfo> {
        return Single.create { emitter ->
            this.appUpdateInfo.addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    emitter.onError(task.exception!!)
                } else if (!emitter.isDisposed) {
                    emitter.onSuccess(task.result)
                }
            }
        }
    }

    override fun getVersionCode(): Single<Int> {
        return (appUpdateManager.appUpdateInfoResult())
            .map { info ->
                val isUpdateAvailable =
                    (info.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE)
                val versionCode = info.availableVersionCode()
                if (isUpdateAvailable) versionCode else -1
            }.subscribeOn(schedulerProvider.io)
    }

    private fun getVersionNameFormGooglePlay(packageName: String): Single<String> {
        return Single.create<String> { emitter ->
            try {
                val url = String.format(FORMAT_GOOGLE_PLAY_PACKAGE_URL, packageName)
                val document = Jsoup.connect(url).get()
                val versionElement =
                    document.select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                val versionName = versionElement.first().text().trim()

                if (!emitter.isDisposed) {
                    emitter.onSuccess(versionName)
                }
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }.subscribeOn(schedulerProvider.io)
    }

    companion object {
        private const val FORMAT_GOOGLE_PLAY_PACKAGE_URL =
            "https://play.google.com/store/apps/details?id=%s"
    }
}