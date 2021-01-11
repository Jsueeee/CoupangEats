package com.example.coupangeats.src.main.storeInfo.menu

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemMenuRecyclerviewSubBinding
import com.example.coupangeats.src.main.storeInfo.models.Menu

class MenuItemRecyclerViewHolder(val binding: ItemMenuRecyclerviewSubBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(menuItem: Menu) {
        Glide.with(ApplicationClass.instance).load(menuItem.menuThumbnail)
            .placeholder(R.drawable.ic_launcher_background).into(binding.menuThumbnail)
        binding.menuName.text = menuItem.menuname
        binding.menuPrice.text = menuItem.menuPrice
        binding.menuDetail.text = menuItem.menuDetail
    }
}