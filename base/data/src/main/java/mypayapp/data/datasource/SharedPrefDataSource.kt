package mypayapp.data.datasource

import java.io.Serializable

interface SharedPrefDataSource {
    fun <T : Any> putData(key: String, data: T)
    fun <T : Any> getData(key: String, defaultValue: T?): Serializable?
}