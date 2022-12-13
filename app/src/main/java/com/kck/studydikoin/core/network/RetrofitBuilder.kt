package com.kck.studydikoin.core.network

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    private const val DEFAULT_TIMEOUT = 15_000L

    private val TAG: String = RetrofitBuilder::class.java.simpleName

    fun create(
//        context: Context,
        url: HttpUrl
    ): Retrofit {
        val okHttpClient = OkHttpClient().newBuilder()
            .apply {
                readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                // Adding network connection Interceptor
//                addInterceptor(ConnectivityInterceptor(context, TRAFFIC_STAT_TAG))
//                authenticator(RefreshAuthenticator(kGet()))
                val loggingInterceptor = HttpLoggingInterceptor().apply {
                    this.setLevel(HttpLoggingInterceptor.Level.BODY)
                }
                addInterceptor(loggingInterceptor)
            }
            .build()

//        val gson = GsonBuilder()
//            .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeTypeAdapter())
//            .enableComplexMapKeySerialization()
//            .create()

        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }


}