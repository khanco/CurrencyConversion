package mypayapp.data.datasource

import mypayapp.data.network.DataParser
import mypayapp.data.network.SERVER_ERROR_SOMETHING_WENT_WRONG
import mypayapp.domain.models.ApiResponseWrapper
import java.io.Serializable

class DataSourceImpl(
    private val remoteDataSource: RemoteDataSourceImpl,
    private val localDataSource: SharedPrefDataSourceImpl,
) : DataSource {
    override suspend fun fetchData(
        endPoint: String,
        body: String,
        queryMap: HashMap<String, String>,
        requestType: String
    ) = remoteDataSource.fetchData(endPoint, body, queryMap, requestType)

    override fun <T : Any> putData(key: String, data: T) = localDataSource.putData(key, data)

    override fun <T : Any> getData(key: String, defaultValue: T?): Serializable? =
        localDataSource.getData(key, defaultValue)

    override fun getErrorMessage(errorBody: String?): String {
        return try {
            errorBody?.let { DataParser.fromJson<ApiResponseWrapper>(it).error?.info }
                ?: SERVER_ERROR_SOMETHING_WENT_WRONG
        } catch (e: Exception) {
            e.printStackTrace()
            SERVER_ERROR_SOMETHING_WENT_WRONG
        }
    }
}