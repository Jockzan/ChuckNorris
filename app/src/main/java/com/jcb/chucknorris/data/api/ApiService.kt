package com.jcb.chucknorris.data.api

import com.jcb.chucknorris.data.model.JokeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("jokes/categories")
    suspend fun getCategories(): List<String>

    @GET("jokes/random")
    suspend fun getJoke(
        @Query("category") category: String
    ): JokeResponse
}