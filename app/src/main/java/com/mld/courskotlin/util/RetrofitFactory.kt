package com.mld.courskotlin.util

import com.google.gson.GsonBuilder
import com.mld.courskotlin.data.api.ApiResponse
import com.mld.courskotlin.data.api.MyApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    private val baseURL = "https://catalog.mld-dev.fr/api/"

    private val interceptor = Interceptor { chain ->
        val request = chain.request()
        val response = chain.proceed(request)

        val gson = GsonBuilder().create()

        if (response.code() in 400..499) {
            // 4xx responses are interceptable errors and we need to wrap the body in our custom error
            val responseBody = response.body()?.string() ?: return@Interceptor response
            val apiResponse = gson.fromJson(responseBody, ApiResponse::class.java)
                ?: return@Interceptor response
            throw Throwable(responseBody)
//            throw ApiError(apiResponse)
        }
        response
    }

    private val interceptorLog = HttpLoggingInterceptor().let {
        it.level = HttpLoggingInterceptor.Level.BODY
        it
    }

    //OkhttpClient for building http request url
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptorLog)
        //.addInterceptor(interceptor)
        .build()


    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitApi: MyApi = retrofit().create(MyApi::class.java)
}