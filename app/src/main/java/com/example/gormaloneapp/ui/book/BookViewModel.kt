package com.example.gormaloneapp.ui.book

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.gormaloneapp.data.Books
import com.example.gormaloneapp.data.local.ProductRepository
import com.example.gormaloneapp.utils.Resource
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private var _bookResponse = MutableLiveData<Resource<Books?>>()
    val bookResponseLive: LiveData<Resource<Books?>> = _bookResponse
    private val repository = ProductRepository(application)

    fun sendApi() {
        _bookResponse.value = Resource.Loading()
        viewModelScope.launch {
            val getBook = repository.getBookList()
            Log.d("TAG", "sendApi: ${getBook.body()}")
            if (getBook.isSuccessful) {
                _bookResponse.postValue(Resource.Success(getBook.body()))
            } else {
                _bookResponse.value = Resource.Error("Error")
            }
        }
    }
}