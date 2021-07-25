package mypayapp.data.network

import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @POST("{endPoint}")
    suspend fun fetchData(
            @Path("endPoint") endPoint: String,
            @Body body: String = "",
            @HeaderMap headerMap: HashMap<String, Any> = HashMap()): Response<String>

    @GET("{endPoint}")
    suspend fun fetchData(
            @Path("endPoint") endPoint: String,
            @QueryMap queryMap: Map<String, String> = HashMap(),
            @HeaderMap headerMap: HashMap<String, Any> = HashMap()): Response<String>
}