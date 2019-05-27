package com.mld.courskotlin.data.api

import androidx.lifecycle.LiveData
import com.mld.courskotlin.data.model.News
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @GET("news")
    fun getNews(): Call<List<News>>

    @GET("news")
    fun getNews2(): Call<List<News>>


    @POST("url/route:paramName")
    fun postNews(/*PARAMS*/): LiveData<List<News>>


    @FormUrlEncoded
    @POST("news")
    fun postNews(
        @Field("title") title: String,
        @Field("desc_short") descShort: String?,
        @Field("desc_long") descLong: String?
    ): Call<ApiResponse.PostNewsApiResponse>
}