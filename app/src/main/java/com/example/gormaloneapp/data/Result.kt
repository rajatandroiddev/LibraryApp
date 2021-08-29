package com.example.gormaloneapp.data

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("book_id")
    val bookId: Int,
    @SerializedName("book_name")
    val bookName: String,
    @SerializedName("book_desc")
    val bookDesc: String,
    @SerializedName("book_author")
    val bookAuthor: String,
    @SerializedName("book_price")
    val bookPrice: String,
    @SerializedName("book_img_url")
    val bookImgUrl: String
)
