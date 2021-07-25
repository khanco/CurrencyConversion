package mypayapp.data.datasource

import java.io.Serializable

class DataSourceImpl(
    private val remoteDataSourceImpl: RemoteDataSourceImpl,
    private val localDataSourceImpl: LocalDataSourceImpl
) : DataSource {
    override suspend fun fetchData(
        endPoint: String,
        body: String,
        queryMap: Map<String, String>,
        requestType: String
    ) = remoteDataSourceImpl.fetchData(endPoint, body, queryMap, requestType)

    override fun <T : Any> putData(key: String, data: T) = localDataSourceImpl.putData(key, data)

    override fun <T : Any> getData(key: String, defaultValue: T?): Serializable? =
        localDataSourceImpl.getData(key, defaultValue)
}