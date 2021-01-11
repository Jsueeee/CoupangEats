package com.example.coupangeats.src.main.storeInfo.menu

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.MenuCategoryRecyclerviewBinding
import com.example.coupangeats.src.main.storeInfo.models.CategoryMenu

class MenuCategoryRecyclerViewHolder(val binding: MenuCategoryRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(categoryMenu: CategoryMenu){
        binding.menuTitle.text = categoryMenu.categoryName//카테고리 타이틀
        binding.categoryDetail.text = categoryMenu.categoryDetail

        val menuItemRecyclerViewAdapter = MenuItemRecyclerViewAdapter()
        binding.recyclerViewCategory.apply {
            adapter = menuItemRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }

        menuItemRecyclerViewAdapter.submitList(categoryMenu.menuList)
    }
}