package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("html_url")
    val url: String?,

    @SerializedName("avatar_url")
    val image: String?
)