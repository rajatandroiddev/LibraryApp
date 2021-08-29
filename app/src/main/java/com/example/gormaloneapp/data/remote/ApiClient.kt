package com.example.gormaloneapp.data.remote

import com.example.gormaloneapp.data.Books
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiClient {

    @POST("api/addNewProduct")
    suspend fun sendToCloud(@Body requestBody: RequestBody)

    @GET("api/getAllAvailableBooks")
    suspend fun getListBooks(): Response<Books>

}