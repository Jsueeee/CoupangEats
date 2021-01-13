package com.example.coupangeats.src.main.DetailListNewStore

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.DetailListNewStore.models.Result

class DetailListNewStoreRecyclerViewHolder(val binding: ItemHomeFamousRestaurantBinding) :
RecyclerView.ViewHolder(binding.root) {
    private var storeIdx: Int = 0


    fun bindWithView(famRestaurantItem: Result) {
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img[0])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage1)
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img[1])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage2)
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img[2])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage3)
        binding.famousRestaurantTitle.text = famRestaurantItem.storeName
        if(famRestaurantItem.storeStar == null) binding.itemMainStoreStoreStar.text = "0"
        else binding.itemMainStoreStoreStar.text = famRestaurantItem.storeStar.toString()
        binding.itemMainStoreReviewCount.text = "(${famRestaurantItem.reviewCount})"
        binding.itemMainStoreDistance.text = famRestaurantItem.distance
        binding.itemMainStoreDeliveryFee.text = famRestaurantItem.deliveryFee
        binding.deliveryTime.text = famRestaurantItem.deliveryTime

        if(famRestaurantItem.isCheetah == "Y"){
            binding.isCheetah.visibility = View.VISIBLE
        }

        if(famRestaurantItem.coupon != null)
            binding.coupon.visibility = View.VISIBLE

        if(famRestaurantItem.isnewStore == "Y"){
            binding.isNewStore.visibility = View.VISIBLE
        }

        storeIdx = famRestaurantItem.storeIdx

    }
}