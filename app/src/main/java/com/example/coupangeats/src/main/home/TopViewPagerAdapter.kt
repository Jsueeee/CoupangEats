package com.example.coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.databinding.ItemHomeTopViewpagerBinding
import com.example.coupangeats.src.main.home.models.PageItem

class TopViewPagerAdapter(private var pageList: ArrayList<PageItem>): RecyclerView.Adapter<TopViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        return TopViewHolder(
            ItemHomeTopViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        holder.bindWithView(pageList[position])
    }

    override fun getItemCount(): Int {
        return pageList.size
    }
}