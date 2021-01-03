package com.example.coupangeats.src.main.home

import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeFranchiseBinding
import com.example.coupangeats.src.main.home.models.FranchiseItem

class FranchiseViewHolder(val binding: ItemHomeFranchiseBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(franchiseItem: FranchiseItem) {
        binding.itemFranchiseImage
        binding.itemFranchiseTitle
    }
}