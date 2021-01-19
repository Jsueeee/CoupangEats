package com.example.coupangeats.src.main.home.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemHomeTopViewpagerBinding
import com.example.coupangeats.src.main.home.models.PageItem
import com.example.coupangeats.src.main.home.models.Promotion

class TopViewHolder(val binding: ItemHomeTopViewpagerBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindWithView(promotion: Promotion){
        Glide.with(ApplicationClass.instance).load(promotion.promotionPhoto)
            .into(binding.itemHomeTopViewpagerImage)
    }
}