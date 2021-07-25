package mypayapp.data.datasource

import android.content.SharedPreferences
import java.io.Serializable

class LocalDataSourceImpl(private val sharedPreference: SharedPreferences) : LocalDataSource {
    override fun <T : Any> putData(key: String, data: T) {
        when (data) {
            is Int -> sharedPreference.edit().putInt(key, data).apply()
            is String -> sharedPreference.edit().putString(key, data).apply()
            is Boolean -> sharedPreference.edit().putBoolean(key, data).apply()
            else -> throw IllegalArgumentException("We only support Int, String, Boolean for Shared preference")
        }
    }

    override fun <T : Any> getData(key: String, defaultValue: T?): Serializable? {
        return when (defaultValue) {
            is Int -> sharedPreference.getInt(key, defaultValue)
            is String -> sharedPreference.getString(key, defaultValue)
            is Boolean -> sharedPreference.getBoolean(key, defaultValue)
            else -> throw IllegalArgumentException("Type mismatch")
        }
    }
}