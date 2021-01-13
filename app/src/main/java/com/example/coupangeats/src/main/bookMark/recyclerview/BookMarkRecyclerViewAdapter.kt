package com.example.coupangeats.src.main.bookMark.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemBookmarkBinding
import com.example.coupangeats.src.main.bookMark.models.HeartStore

class BookMarkRecyclerViewAdapter: RecyclerView.Adapter<BookMarkViewHolder>() {

    private var bookMarkList = ArrayList<HeartStore>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookMarkViewHolder {
        return BookMarkViewHolder(
            ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookMarkViewHolder, position: Int) {
        holder.bindWithView(bookMarkList[position])
    }

    override fun getItemCount(): Int {
        return bookMarkList.size
    }

    fun submitList(bookMarkList: ArrayList<HeartStore>){
        this.bookMarkList = bookMarkList
        notifyDataSetChanged()
    }
}