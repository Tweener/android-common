package com.tweener.android.common.connectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * @author Vivien Mahe
 */
class ConnectivityUtils {

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }

        fun getConnectivityStatus(context: Context): ConnectivityStatus {
            val connectivityStatus: ConnectivityStatus

            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo

            if (activeNetworkInfo?.state == NetworkInfo.State.CONNECTED) {
                if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                    connectivityStatus = ConnectivityStatus.WIFI
                } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                    connectivityStatus = ConnectivityStatus.MOBILE
                } else {
                    connectivityStatus = ConnectivityStatus.NO_CONNECTION
                }
            } else {
                connectivityStatus = ConnectivityStatus.NO_CONNECTION
            }

            return connectivityStatus
        }
    }
}