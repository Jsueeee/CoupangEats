package com.example.coupangeats.src.main.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemHomeFranchiseBinding
import com.example.coupangeats.src.main.home.models.Franchise
import com.example.coupangeats.src.main.home.models.FranchiseItem

class FranchiseViewHolder(val binding: ItemHomeFranchiseBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(franchiseItem: Franchise) {
        Glide.with(ApplicationClass.instance).load(franchiseItem.storePhoto)
            .into(binding.itemFranchiseImage)
        binding.itemFranchiseTitle.text = franchiseItem.storeName
        binding.itemFranchiseStoreStar.text = franchiseItem.storeStar.toString()
        binding.itemFranchiseReviewCount.text = "(${franchiseItem.reviewCount})"
        binding.itemFranchiseDistance.text = franchiseItem.distance
        binding.itemFranchiseDeliveryFee.text = franchiseItem.deliveryFee
    }
}