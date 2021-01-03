package com.example.coupangeats.src.main.home

import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.home.models.FamRestaurantItem

class FamRestaurantViewHolder(val binding: ItemHomeFamousRestaurantBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(famRestaurantItem: FamRestaurantItem){
        binding.famousRestaurantImage
        binding.famousRestaurantTitle
    }
}