package mypayapp.data.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.URLDecoder
import java.util.concurrent.TimeUnit

object RetrofitFactory {

    private var BASE_URL = "http://api.currencylayer.com/"

    fun makeRetrofitService(): RetrofitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(makeOkHttpClient())
        .addConverterFactory(ScalarsConverterFactory.create())
        .build().create(RetrofitService::class.java)


    private fun makeOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
//                .hostnameVerifier { _, _ -> true }
            .addNetworkInterceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                val decodeUrl = URLDecoder.decode(chain.request().url.toString(), "UTF-8")
                requestBuilder.url(decodeUrl)
                requestBuilder.header(
                    "timestamp",
                    (System.currentTimeMillis() + (1 * 1000)).toString()
                )
                requestBuilder.header("Content-Type", "application/json; charset=utf-8")
                requestBuilder.header("Accept", "application/json")
                chain.proceed(requestBuilder.build())
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()
    }
}