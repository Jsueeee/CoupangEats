package com.example.coupangeats.src.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeMenuCategoryBinding
import com.example.coupangeats.src.main.home.itemInterface.CategoryRecyclerViewInterface
import com.example.coupangeats.src.main.home.viewholder.CategoryViewHolder
import com.example.coupangeats.src.main.home.models.CategoryItem

class CategoryRecyclerViewAdapter(categoryRecyclerViewInterface: CategoryRecyclerViewInterface): RecyclerView.Adapter<CategoryViewHolder>() {

    private var categoryItemList = ArrayList<CategoryItem>()
    private var categoryRecyclerViewInterface: CategoryRecyclerViewInterface

    init {
        this.categoryRecyclerViewInterface = categoryRecyclerViewInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemHomeMenuCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindWithView(categoryItemList[position])
    }

    override fun getItemCount(): Int {
        return categoryItemList.size
    }

    fun submitList(categoryItemList: ArrayList<CategoryItem> ){
        this.categoryItemList = categoryItemList
    }
}