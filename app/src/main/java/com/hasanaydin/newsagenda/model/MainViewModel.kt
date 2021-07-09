package com.hasanaydin.newsagenda.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hasanaydin.newsagenda.data.NewsData
import com.hasanaydin.newsagenda.service.NewsAPIService
import com.hasanaydin.newsagenda.service.NewsAPIUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val liveData : MutableLiveData<NewsData> = MutableLiveData()

    fun loadData (){

        val gson = GsonBuilder().setLenient().create()

        val retrofit : Retrofit = Retrofit.Builder().baseUrl(NewsAPIUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        val apiService = retrofit.create(NewsAPIService::class.java)

        val call : Call<NewsData> = apiService.getNews("d9c0b94025e44775aca56658f264e6a2","news","2021-06-27","popularity")

        call.enqueue(object : Callback<NewsData> {

            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {

                if (response != null){

                    liveData.postValue(response.body())

                }

            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                t.printStackTrace()
            }


        })

    }

}


