package mypayapp.data.network

import retrofit2.Response
import retrofit2.http.*

/***
 * These are the only two methods needed which can cover almost all type of api calls
 * Doesn't matter you have one api or thousands of api in your project
 *
 * Since we are returning response in base form (String) further there is DataParser.class which
 * can convert the raw (String) data into required POJO and vice-versa.
 */
interface RetrofitService {

    @POST("{endPoint}")
    suspend fun fetchData(
        @Path("endPoint") endPoint: String,
        @Body body: String = "",
        @HeaderMap headerMap: HashMap<String, Any> = HashMap()
    ): Response<String>

    @GET("{endPoint}")
    suspend fun fetchData(
        @Path("endPoint") endPoint: String,
        @QueryMap queryMap: Map<String, String> = HashMap(),
        @HeaderMap headerMap: HashMap<String, Any> = HashMap()
    ): Response<String>
}