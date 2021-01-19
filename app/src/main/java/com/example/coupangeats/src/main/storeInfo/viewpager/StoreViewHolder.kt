package com.example.coupangeats.src.main.storeInfo.viewpager

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemStoreViewpagerBinding

class StoreViewHolder(val binding: ItemStoreViewpagerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindWithView(storePhoto: String) {
        Glide.with(ApplicationClass.instance).load(storePhoto)
            .into(binding.itemStoreViewpager)
    }
}