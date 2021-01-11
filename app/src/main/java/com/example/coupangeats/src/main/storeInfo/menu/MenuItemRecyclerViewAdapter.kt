package com.example.coupangeats.src.main.storeInfo.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemMenuRecyclerviewSubBinding
import com.example.coupangeats.src.main.storeInfo.models.Menu

class MenuItemRecyclerViewAdapter : RecyclerView.Adapter<MenuItemRecyclerViewHolder>(){

    private var menuItemList = ArrayList<Menu>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemRecyclerViewHolder {
        return MenuItemRecyclerViewHolder(
            ItemMenuRecyclerviewSubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuItemRecyclerViewHolder, position: Int) {
        holder.bindWithView(menuItemList[position])
    }

    override fun getItemCount(): Int {
        return menuItemList.size
    }

    fun submitList(menuItemList: ArrayList<Menu>){
        this.menuItemList = menuItemList
        notifyDataSetChanged()
    }
}