package com.example.trendingrepos.data

import com.example.trendingrepos.data.remote.TrendingReposAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com"
private val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
    BASE_URL
).build()

object API {
    val trendingReposAPI: TrendingReposAPI by lazy {
        retrofit.create(TrendingReposAPI::class.java)
    }
}