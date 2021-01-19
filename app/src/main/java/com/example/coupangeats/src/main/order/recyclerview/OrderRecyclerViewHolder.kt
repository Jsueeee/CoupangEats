package com.example.coupangeats.src.main.order.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemOrderRecyclerviewBinding
import com.example.coupangeats.src.main.order.models.OrderResult

class OrderRecyclerViewHolder(val binding: ItemOrderRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(orderResult: OrderResult) {
        binding.storeName.text = orderResult.storeName
        binding.orderTime.text = orderResult.orderTime
        binding.orderStateName.text = orderResult.orderStateName
        binding.orderPrice.text = orderResult.orderPrice
        Glide.with(ApplicationClass.instance).load(orderResult.storePhoto)
            .into(binding.storePhoto)
        orderResult.menuList.forEach {
            it.forEach {
                binding.menuName.text = it.menuName
            }

        }
    }
}