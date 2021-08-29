package com.example.gormaloneapp.ui.book

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.gormaloneapp.R
import com.example.gormaloneapp.data.adapter.BookAdapter
import com.example.gormaloneapp.utils.Resource

class BookActivity : AppCompatActivity() {

    private val bookViewModel: BookViewModel by viewModels()
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle)
        val loading = findViewById<LottieAnimationView>(R.id.animationView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@BookActivity)
            bookAdapter = BookAdapter()
            setHasFixedSize(true)
        }

        bookViewModel.sendApi()
        bookViewModel.bookResponseLive.observe(this, { response ->
            response?.let {
                when (response) {
                    is Resource.Success -> {
                        Handler(Looper.getMainLooper()).postDelayed({
                            loading.visibility = View.GONE
                            bookAdapter.submitList(response.data?.results)
                            recyclerView.adapter = bookAdapter
                        }, 2000)
                    }
                    is Resource.Error -> Toast.makeText(this@BookActivity, response.message, Toast.LENGTH_SHORT).show()
                    is Resource.Loading -> loading.playAnimation()
                }
            }
        })
    }
}