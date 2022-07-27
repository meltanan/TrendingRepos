package com.example.myapplication.data

import com.google.gson.annotations.SerializedName


data class Listing(
    val items: List<RepoItem>
)
data class RepoItem(
    val name: String,
    val owner: Owner?,
    val visibility: String?,
    val watchers: Int?,
    val language: String?,

    @SerializedName("open_issues")
    val openIssues: Int?,

    @SerializedName("default_branch")
    val defaultBranch: String?,
)