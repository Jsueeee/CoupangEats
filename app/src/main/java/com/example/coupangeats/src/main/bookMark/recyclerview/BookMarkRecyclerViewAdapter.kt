package com.example.coupangeats.src.main.bookMark.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemBookmarkBinding
import com.example.coupangeats.src.main.bookMark.models.HeartStore
import com.example.coupangeats.src.main.storeInfo.StoreInfoActivity

class BookMarkRecyclerViewAdapter : RecyclerView.Adapter<BookMarkViewHolder>() {

    private var bookMarkList = ArrayList<HeartStore>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookMarkViewHolder {
        return BookMarkViewHolder(
            ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookMarkViewHolder, position: Int) {
        holder.bindWithView(bookMarkList[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(ApplicationClass.instance, StoreInfoActivity::class.java)
            intent.putExtra("storeIdx", bookMarkList[position].storeIdx)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(ApplicationClass.instance, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return bookMarkList.size
    }

    fun submitList(bookMarkList: ArrayList<HeartStore>) {
        this.bookMarkList = bookMarkList
        notifyDataSetChanged()
    }
}