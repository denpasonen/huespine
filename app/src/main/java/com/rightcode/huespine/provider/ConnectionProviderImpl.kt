package com.rightcode.huespine.provider

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.rightcode.huespine.remote.provider.ConnectionProvider
import javax.inject.Inject

internal class ConnectionProviderImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager
) : ConnectionProvider {
    override val isReachable: Boolean
        get() {
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                    ?: return false
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        }
}