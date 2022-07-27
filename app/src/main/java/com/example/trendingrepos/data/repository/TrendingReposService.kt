package com.example.trendingrepos.data.repository

import com.example.trendingrepos.data.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

object TrendingReposService {

    suspend fun fetchTrendingRepos(nameSearch: String) = withContext(Dispatchers.IO) {
        val sort = "stars"
        val order = "desc"
        val response = try {
            API.trendingReposAPI.getRepos(q = nameSearch, sort = sort, order = order).execute()
        } catch (e: Exception) {
            null
        }
        response?.body()?.let {
            return@withContext it.items
        }
    }
}