package com.example.coupangeats.src.main.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeTopViewpagerBinding
import com.example.coupangeats.src.main.home.models.PageItem

class TopViewHolder(val binding: ItemHomeTopViewpagerBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindWithView(pageItem: PageItem){
        binding.itemHomeTopViewpagerImage.setImageResource(pageItem.item_image_url.toInt())
    }
}