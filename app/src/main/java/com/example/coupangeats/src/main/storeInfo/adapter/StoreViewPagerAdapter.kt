package com.example.coupangeats.src.main.storeInfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemStoreViewpagerBinding
import com.example.coupangeats.src.main.storeInfo.viewholder.StoreViewHolder

class StoreViewPagerAdapter(): RecyclerView.Adapter<StoreViewHolder>() {

    private var storePhotoList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            ItemStoreViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bindWithView(storePhotoList[position])
    }

    override fun getItemCount(): Int {
        return storePhotoList.size
    }

    fun submitList(storePhotoList: ArrayList<String>){
        this.storePhotoList = storePhotoList
        notifyDataSetChanged()
    }

}