package mypayapp.data.datasource

import mypayapp.data.network.HttpCodes
import mypayapp.data.network.RetrofitService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import retrofit2.Response
import kotlin.reflect.KSuspendFunction1

class RemoteDataSourceImpl(private val service: RetrofitService) : RemoteDataSource {

    private val headerMap = HashMap<String, Any>()

    private fun setHeaderData() {
        // set header data here like device info user common info
    }

    override suspend fun fetchData(
        endPoint: String,
        body: String,
        queryMap: Map<String, String>,
        requestType: String
    ): Response<String> {
        setHeaderData()
        val requestSupport = RequestSupport(endPoint, body, queryMap, requestType)
        return executeRequest(requestSupport, ::getBodyStringWithQueryMap)
    }

    private suspend fun getBodyStringWithQueryMap(requestSupport: RequestSupport): Response<String> {
        return try {
            if (requestSupport.requestType.equals("post", true)) {
                service.fetchData(requestSupport.endPoint, requestSupport.body, headerMap)
            } else {
                service.fetchData(requestSupport.endPoint, requestSupport.queryMap, headerMap)
            }
        } catch (e: Exception) {
            val http999 = HttpCodes.Http999()
            Response.error(
                http999.code, ResponseBody.create(
                    "application/json".toMediaTypeOrNull(),
                    "{\"msg\":\"${http999.message}\"}"
                )
            )
        }
    }

    private suspend fun executeRequest(
        requestSupport: RequestSupport,
        apiFunctionRef: KSuspendFunction1<RequestSupport, Response<String>>
    ): Response<String> {
        return apiFunctionRef(requestSupport)
    }

    data class RequestSupport(
        val endPoint: String,
        val body: String,
        val queryMap: Map<String, String>,
        val requestType: String
    )
}