package com.example.coupangeats.src.main.menuInfo.viewPager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemMenuViewpagerBinding

class MenuViewPagerAdapter(): RecyclerView.Adapter<MenuViewHolder>() {

    private var menuPhotoList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            ItemMenuViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindWithView(menuPhotoList[position])
    }

    override fun getItemCount(): Int {
        return menuPhotoList.size
    }

    fun submitList(menuPhotoList: ArrayList<String>){
        this.menuPhotoList = menuPhotoList
        notifyDataSetChanged()
    }
}