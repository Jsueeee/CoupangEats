package com.example.coupangeats.src.main.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.home.models.MainStore

class FamRestaurantViewHolder(val binding: ItemHomeFamousRestaurantBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(famRestaurantItem: MainStore){
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img_arr[0])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage1)
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img_arr[1])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage2)
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img_arr[2])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage3)
        binding.famousRestaurantTitle.text = famRestaurantItem.storeName
        binding.itemMainStoreStoreStar.text = famRestaurantItem.storeStar.toString()
        binding.itemMainStoreReviewCount.text = "(${famRestaurantItem.reviewCount})"
        binding.itemMainStoreDistance.text = famRestaurantItem.distance
        binding.itemMainStoreDeliveryFee.text = famRestaurantItem.deliveryFee

    }
}