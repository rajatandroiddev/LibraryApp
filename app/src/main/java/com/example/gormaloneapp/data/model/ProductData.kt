package com.example.gormaloneapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class ProductData(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "product_name") val product_name: String?,
    @ColumnInfo(name = "product_description") val product_description: String?,
    @ColumnInfo(name = "quantity") val product_quantity: String?,
    @ColumnInfo(name = "price") val product_price: String?,
    @ColumnInfo(name = "user_phone_number") var user_phone_num: String
)