package com.hasanaydin.newsagenda.data

import com.google.gson.annotations.SerializedName

data class NewsData (

    @SerializedName("status") val status : String,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("articles") val articles : List<ArticlesData>

        )
