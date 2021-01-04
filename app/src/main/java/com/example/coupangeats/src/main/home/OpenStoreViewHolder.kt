package com.example.coupangeats.src.main.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemHomeOpenstoreBinding
import com.example.coupangeats.src.main.home.models.OpenStore

class OpenStoreViewHolder(val binding: ItemHomeOpenstoreBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(openStoreItem: OpenStore) {
        Glide.with(ApplicationClass.instance).load(openStoreItem.storePhoto)
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemOpenStoreImage)
        binding.itemOpenStoreTitle.text = openStoreItem.storeName
        binding.itemOpenStoreDistance.text = openStoreItem.distance
        binding.itemOpenStoreDeliveryFee.text = openStoreItem.deliveryFee
    }
}