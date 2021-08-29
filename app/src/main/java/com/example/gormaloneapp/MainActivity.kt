package com.example.gormaloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.gormaloneapp.ui.addProduct.AddProductActivity
import com.example.gormaloneapp.ui.addProduct.AddProductViewModel
import com.example.gormaloneapp.ui.book.BookActivity

class MainActivity : AppCompatActivity() {

    private val addProductViewModel: AddProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnProduct).setOnClickListener {
            startActivity(Intent(this@MainActivity, AddProductActivity::class.java))
        }

        findViewById<Button>(R.id.btSync).setOnClickListener {
            addProductViewModel.saveDataToCloud()
        }

        findViewById<Button>(R.id.btBooks).setOnClickListener{
        startActivity(Intent(this@MainActivity, BookActivity::class.java))
        }
    }
}