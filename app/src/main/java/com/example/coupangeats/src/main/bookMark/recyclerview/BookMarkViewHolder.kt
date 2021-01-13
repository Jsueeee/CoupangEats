package com.example.coupangeats.src.main.bookMark.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemBookmarkBinding
import com.example.coupangeats.src.main.bookMark.models.HeartStore

class BookMarkViewHolder(val binding: ItemBookmarkBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(heartStore: HeartStore) {
        binding.itemStoreName.text = heartStore.storeName
        if(heartStore.storeStar == null){
            binding.itemStoreStar.text = "0"
        }else{
            binding.itemStoreStar.text = heartStore.storeStar.toString()
        }
        binding.itemReviewCount.text = "(" + heartStore.reviewCount.toString() + ")"
        binding.itemDeliveryFee.text = heartStore.deliveryFee
        binding.itemDeliveryTime.text = heartStore.deliveryTime
        if(heartStore.coupon == null){
            binding.coupon.visibility = View.GONE
        }
        Glide.with(ApplicationClass.instance).load(heartStore.storePhoto).into(binding.itemStorePhoto)
        binding.itemDistance.text = heartStore.distance
        if(heartStore.isCheetah == "N"){
            binding.isCheetah.visibility = View.GONE
        }

    }
}