package com.example.gormaloneapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gormaloneapp.data.model.ProductData

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(product: ProductData)

    @Query("Select * From Product")
    suspend fun fetchAll(): ProductData

}