package com.example.coupangeats.src.main.storeInfo.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.MenuCategoryRecyclerviewBinding
import com.example.coupangeats.src.main.storeInfo.models.CategoryMenu

class MenuCategoryRecyclerViewAdapter: RecyclerView.Adapter<MenuCategoryRecyclerViewHolder>() {

    private var categoryItemList = ArrayList<CategoryMenu>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuCategoryRecyclerViewHolder {
        return MenuCategoryRecyclerViewHolder(
            MenuCategoryRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuCategoryRecyclerViewHolder, position: Int) {
        holder.bindWithView(categoryItemList[position])
    }

    override fun getItemCount(): Int {
        return categoryItemList.size
    }

    fun submitList(categoryItemList: ArrayList<CategoryMenu>){
        this.categoryItemList = categoryItemList
        notifyDataSetChanged()
    }
}