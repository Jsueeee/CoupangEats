package com.example.coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeOpenstoreBinding
import com.example.coupangeats.src.main.home.models.Franchise
import com.example.coupangeats.src.main.home.models.OpenStore

class OpenStoreRecyclerViewAdapter: RecyclerView.Adapter<OpenStoreViewHolder>() {

    private var openStoreItemList = ArrayList<OpenStore>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenStoreViewHolder {
        return OpenStoreViewHolder(
            ItemHomeOpenstoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OpenStoreViewHolder, position: Int) {
        holder.bindWithView(openStoreItemList[position])
    }

    override fun getItemCount(): Int {
        return openStoreItemList.size
    }
    fun submitList(openStoreItemList: ArrayList<OpenStore>) {
        this.openStoreItemList = openStoreItemList
        notifyDataSetChanged()
    }

}