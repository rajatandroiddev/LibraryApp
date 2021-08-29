package com.example.gormaloneapp.ui.addProduct

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.gormaloneapp.data.RequestParam
import com.example.gormaloneapp.data.local.ProductRepository
import com.example.gormaloneapp.data.database.AppDatabase
import com.example.gormaloneapp.data.model.ProductData
import com.example.gormaloneapp.utils.Resource
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class AddProductViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProductRepository(application)
    var responseFetch = MutableLiveData<Resource<ProductData?>>()
    var storeDataLiveData= MutableLiveData<Resource<List<ProductData?>?>>()

    fun storeData(productData: ProductData) {
        viewModelScope.launch {
            productData.let {
                Log.d("TAG", "storeData: $productData")
                repository.storeProductDetails(productData)
                responseFetch.postValue(Resource.Success(productData))
            }
        }
    }

    fun saveDataToCloud() {

        viewModelScope.launch {

            /* fetching from room database */
            val productDataList: ProductData =
                AppDatabase.getInstance(getApplication()).productDao().fetchAll()

            Log.d("TAG", "ROOM DATA :::: $productDataList")
            val request=RequestParam(productDataList.product_name,productDataList.product_description,productDataList.product_quantity,productDataList.product_price,"7978200654")
            val json = Gson().toJson(request)
            Log.d("TAG", "JSON :::: $json")

            val body = json.toRequestBody("application/json".toMediaType())
            Log.d("TAG", "BODY :::: $body")
            val getData = repository.sendData(body)

            Log.d("TAG", "Data from API :::: $getData")
        }
    }

}