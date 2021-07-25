package mypayapp.data.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataParser {
    companion object {
        inline fun <reified T> fromJson(json: String): T {
            return Gson().fromJson(json, object : TypeToken<T>() {}.type)
        }

        fun <T> toJson(body: T): String {
            return Gson().toJson(body, object : TypeToken<T>(){}.type)
        }
    }
}