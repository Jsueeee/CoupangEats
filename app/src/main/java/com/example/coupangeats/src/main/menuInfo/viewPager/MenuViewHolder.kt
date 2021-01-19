package com.example.coupangeats.src.main.menuInfo.viewPager

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemMenuViewpagerBinding

class MenuViewHolder(val binding: ItemMenuViewpagerBinding):
RecyclerView.ViewHolder(binding.root){
    fun bindWithView(menuPhoto: String){
        Glide.with(ApplicationClass.instance).load(menuPhoto)
            .into(binding.itemMenuViewpager)
    }
}