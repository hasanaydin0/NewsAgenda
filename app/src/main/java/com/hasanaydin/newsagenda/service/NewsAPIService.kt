package com.hasanaydin.newsagenda.service

import com.hasanaydin.newsagenda.data.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("/v2/everything")

    fun getNews(

        @Query("apiKey") apiKey:String,
        @Query("q") q:String,
        @Query("from") from: String,
        @Query("sortBy") sortBy:String

    ):Call<NewsData>

}