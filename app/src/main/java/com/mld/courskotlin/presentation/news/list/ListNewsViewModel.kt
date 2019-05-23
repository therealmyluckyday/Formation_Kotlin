package com.mld.courskotlin.presentation.news.list

import androidx.lifecycle.*
import com.mld.courskotlin.data.model.News
import com.mld.courskotlin.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListNewsViewModel : ViewModel() {

    val listNews = MutableLiveData<List<News>>()

    fun fetchNews() {

        val call = RetrofitFactory.retrofitApi.getNews()

        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }

            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful) {
                    listNews.postValue(response.body())
                }
            }
        })
    }


    fun fetchNews2() : LiveData<List<News>> {

        val data = MutableLiveData<List<News>>()

        val call = RetrofitFactory.retrofitApi.getNews()

        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            }

            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }
        })

        return data
    }

    fun fetchNews3() : LiveData<List<News>> {
        return RetrofitFactory.retrofitApi.getNews2()
    }

    fun fetchNews4() {
        Transformations.map(RetrofitFactory.retrofitApi.getNews2()) {
            listNews.value = it
        }
    }

}