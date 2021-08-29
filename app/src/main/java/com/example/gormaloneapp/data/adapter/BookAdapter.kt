package com.example.gormaloneapp.data.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gormaloneapp.R
import com.example.gormaloneapp.data.Result


class BookAdapter : ListAdapter<Result, BookAdapter.BookViewHolder>(BookDiffCallback) {

    inner class BookViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView)
        val textBookName: TextView = itemView.findViewById(R.id.textBookName)
        val textBookDesc: TextView = itemView.findViewById(R.id.textDescription)
        val textBookAuthor: TextView = itemView.findViewById(R.id.textAuthor)
        val textBookPrice: TextView = itemView.findViewById(R.id.textPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.book_recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val itemBook = getItem(position)
        holder.textBookName.text = itemBook.bookName
        Log.d("Book Name :::",itemBook.bookName )
        holder.textBookDesc.text = itemBook.bookDesc
        Log.d("Book Name :::",itemBook.bookDesc )
        holder.textBookAuthor.text = itemBook.bookAuthor
        Log.d("Book Name :::",itemBook.bookAuthor )
        holder.textBookPrice.text = itemBook.bookPrice
        Log.d("Book Name :::",itemBook.bookPrice )
        Glide.with(holder.itemView.context).load(itemBook.bookImgUrl).centerCrop().into(holder.image)
    }

    object BookDiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.bookId == newItem.bookId
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
}