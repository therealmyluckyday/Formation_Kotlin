package com.mld.courskotlin.presentation.news.creation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mld.courskotlin.data.api.ApiResponse
import com.mld.courskotlin.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreationNewsViewModel : ViewModel() {


    fun postNews(title: String, descShort: String?, descLong: String? = null)
            : LiveData<ApiResponse.PostNewsApiResponse> {


        val obs = MutableLiveData<ApiResponse.PostNewsApiResponse>()

        RetrofitFactory.retrofitApi.postNews(title, descShort, descLong)
            .enqueue(object : Callback<ApiResponse.PostNewsApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse.PostNewsApiResponse>,
                    response: Response<ApiResponse.PostNewsApiResponse>
                ) {

                    obs.value = response.body()
                }

                override fun onFailure(call: Call<ApiResponse.PostNewsApiResponse>, t: Throwable) {
                    obs.value = ApiResponse.PostNewsApiResponse()
                }

            })


        return obs
    }

}