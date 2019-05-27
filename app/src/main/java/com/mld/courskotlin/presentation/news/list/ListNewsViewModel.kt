package com.mld.courskotlin.presentation.news.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mld.courskotlin.data.database.DataBaseFactory
import com.mld.courskotlin.data.database.MyDatabase
import com.mld.courskotlin.data.model.News
import com.mld.courskotlin.util.InternetManager
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


    fun fetchNews2(): LiveData<List<News>> {

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

    fun fetchNews3(context: Context): LiveData<List<News>> {

        if(InternetManager.isConnected(context)) {
            val obs = MutableLiveData<List<News>>()
            RetrofitFactory.retrofitApi.getNews2().enqueue(object : Callback<List<News>> {
                override fun onFailure(call: Call<List<News>>, t: Throwable) {
                    //To change body of created functions use File | Settings | File Templates.
                    obs.value = emptyList()
                }

                override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                    obs.value = response.body()
                    Thread(Runnable {
                        DataBaseFactory.myDatabase.newsDao().insertAll(response.body())
                    }).start()

                }

            })
            return obs
        } else {
             return DataBaseFactory.myDatabase.newsDao().fetchAll()
        }

    }

}