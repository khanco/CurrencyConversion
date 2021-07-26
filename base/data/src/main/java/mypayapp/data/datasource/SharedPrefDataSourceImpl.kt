package mypayapp.data.datasource

import android.content.SharedPreferences
import java.io.Serializable

/***
 * This class is responsible for saving/retrieving data from shared preference
 */
class SharedPrefDataSourceImpl(private val sharedPreference: SharedPreferences) :
    SharedPrefDataSource {
    override fun <T : Any> putData(key: String, data: T) {
        when (data) {
            is Int -> sharedPreference.edit().putInt(key, data).apply()
            is String -> sharedPreference.edit().putString(key, data).apply()
            is Boolean -> sharedPreference.edit().putBoolean(key, data).apply()
            is Long -> sharedPreference.edit().putLong(key, data).apply()
            is Float -> sharedPreference.edit().putFloat(key, data).apply()
            else -> throw IllegalArgumentException("Type mismatch")
        }
    }

    override fun <T : Any> getData(key: String, defaultValue: T?): Serializable? {
        return when (defaultValue) {
            is Int -> sharedPreference.getInt(key, defaultValue)
            is String -> sharedPreference.getString(key, defaultValue)
            is Boolean -> sharedPreference.getBoolean(key, defaultValue)
            is Long -> sharedPreference.getLong(key, defaultValue)
            is Float -> sharedPreference.getFloat(key, defaultValue)
            else -> throw IllegalArgumentException("Type mismatch")
        }
    }
}