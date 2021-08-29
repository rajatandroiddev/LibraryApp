package com.example.gormaloneapp.data

import com.google.gson.annotations.SerializedName

data class ResponseParam(
    @SerializedName("success")
    val success: Int,
    @SerializedName("message")
    val message: String
)
