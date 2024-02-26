package com.pisces.piscesnews.data.remote

import com.pisces.piscesnews.data.remote.dto.NewsResponse
import com.pisces.piscesnews.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("page") page:Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey:String= API_KEY):NewsResponse

}