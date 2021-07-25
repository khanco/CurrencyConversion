package mypayapp.data.datasource

import retrofit2.Response

interface RemoteDataSource {
    suspend fun fetchData(
        endPoint: String,
        body: String = "",
        queryMap: Map<String, String> = HashMap(),
        requestType: String = "post"
    ): Response<String>
}