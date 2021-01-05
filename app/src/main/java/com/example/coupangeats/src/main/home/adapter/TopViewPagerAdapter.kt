package com.example.coupangeats.src.main.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.databinding.ItemHomeTopViewpagerBinding
import com.example.coupangeats.src.main.home.itemInterface.TopViewPagerInterface
import com.example.coupangeats.src.main.home.models.Promotion
import com.example.coupangeats.src.main.home.viewholder.TopViewHolder

class TopViewPagerAdapter(topViewPagerInterface: TopViewPagerInterface): RecyclerView.Adapter<TopViewHolder>() {

    private var promotionList = ArrayList<Promotion>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        return TopViewHolder(
            ItemHomeTopViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        Log.d(TAG, "TopViewPagerAdapter - onBindViewHolder() : promotion[position] / ${promotionList[position]}")
        holder.bindWithView(promotionList[position])
    }

    override fun getItemCount(): Int {
        return promotionList.size
        Log.d(TAG, "TopViewPagerAdapter - getItemCount() : promotion.size / ${promotionList.size}")
    }

    fun submitList(promotionList: ArrayList<Promotion> ){
        this.promotionList = promotionList
        Log.d(TAG, "TopViewPagerAdapter - submitList() : ${this.promotionList}")
        notifyDataSetChanged()
    }
}