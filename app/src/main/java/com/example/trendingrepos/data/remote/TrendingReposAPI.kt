package com.example.trendingrepos.data.remote

import com.example.myapplication.data.Listing
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface TrendingReposAPI {

    @GET("/search/repositories")
    fun getRepos(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
    ): Call<Listing>
}