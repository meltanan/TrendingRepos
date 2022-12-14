package com.example.trendingrepos.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.RepoItem
import com.example.trendingrepos.data.repository.TrendingReposService

class HomeActivityViewModel: ViewModel() {
    var trendingRepos = MutableLiveData<List<RepoItem>>()

    suspend fun testing(nameSearch: String) {
        val response = TrendingReposService.fetchTrendingRepos(nameSearch)
        response?.let {
            trendingRepos.value = it
        }
    }
}