package com.example.gormaloneapp.data.local

import android.content.Context
import com.example.gormaloneapp.data.database.AppDatabase
import com.example.gormaloneapp.data.model.ProductData
import com.example.gormaloneapp.data.remote.ApiInterface
import okhttp3.RequestBody

class ProductRepository(context: Context) {

    private val productDao = AppDatabase.getInstance(context).productDao()

    suspend fun storeProductDetails(productData: ProductData) =
        productDao.insertProduct(productData)

    suspend fun sendData(
        requestBody: RequestBody) = ApiInterface.storeApi.sendToCloud(requestBody)

    suspend fun getBookList() = ApiInterface.storeApi.getListBooks()
}