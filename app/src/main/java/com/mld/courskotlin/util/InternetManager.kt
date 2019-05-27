package com.mld.courskotlin.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object InternetManager {

    fun isConnected (context : Context) : Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }

}