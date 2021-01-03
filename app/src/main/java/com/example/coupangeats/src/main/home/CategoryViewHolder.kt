package com.example.coupangeats.src.main.home

import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeMenuCategoryBinding
import com.example.coupangeats.src.main.home.models.CategoryItem

class CategoryViewHolder(val binding: ItemHomeMenuCategoryBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(categoryItem: CategoryItem){
        binding.itemCategoryImage.setImageResource(categoryItem.item_image)
        binding.itemCategoryText.text = categoryItem.item_text
    }
}