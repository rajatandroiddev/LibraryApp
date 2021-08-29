package com.example.gormaloneapp.ui.addProduct

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.gormaloneapp.MainActivity
import com.example.gormaloneapp.R
import com.example.gormaloneapp.data.model.ProductData
import com.example.gormaloneapp.databinding.ActivityAddProductBinding
import com.example.gormaloneapp.utils.Resource

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding
    private val addProductViewModel: AddProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpUi()
        binding.btnProduct.setOnClickListener {
            val productData = ProductData(0,
                binding.productInput.editText?.text.toString(),
                binding.descriptionInput.editText?.text.toString(),
                binding.quantityInput.editText?.text.toString(),
                binding.priceInput.editText?.text.toString(),
                "7978200654"
            )
            addProductViewModel.storeData(productData)
        }

        addProductViewModel.responseFetch.observe(this, Observer {
            it?.let {
                when (it) {
                    is Resource.Success -> {
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    else -> Log.d("TAG", "onCreate: Invalid")
                }
            }
        })

    }

    private fun setUpUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_product)
        val view = binding.root
        setContentView(view)
    }

}