package com.example.gormaloneapp.data

import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("results")
    val results: List<Result>? = null
)
