package com.example.gormaloneapp.data

import com.google.gson.annotations.SerializedName

data class RequestParam(
    @SerializedName("product_name")
    val productName: String?,
    @SerializedName("product_desc")
    val productDesc: String?,
    @SerializedName("product_price")
    val productPrice: String?,
    @SerializedName("product_quantity")
    val productQuantity: String?,
    @SerializedName("user_mobile_no")
    val userMobileNo: String?
)
