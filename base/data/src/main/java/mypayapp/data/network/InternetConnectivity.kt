package mypayapp.data.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build


/****
 * This class is used to check if device is connected to internet or not.
 *
 *
 * isOnline method returns the boolean value represents network connection
 */
@Suppress("DEPRECATION")
class InternetConnectivityImpl(context: Application) : InternetConnectivity {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun isOnline(): Boolean {
        if (Build.VERSION.SDK_INT < 23) {
            val ni: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (ni != null) {
                return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
            }
        } else {
            val n: Network? = connectivityManager.activeNetwork
            if (n != null) {
                val nc: NetworkCapabilities? = connectivityManager.getNetworkCapabilities(n)
                return nc?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false
                        || nc?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false
            }
        }
        return false
    }
}

interface InternetConnectivity {
    fun isOnline(): Boolean
}