package com.example.coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeFranchiseBinding
import com.example.coupangeats.src.main.home.models.FranchiseItem

class FranchiseRecyclerViewAdapter : RecyclerView.Adapter<FranchiseViewHolder>() {

    private var franchiseItemList = ArrayList<FranchiseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FranchiseViewHolder {
        return FranchiseViewHolder(
            ItemHomeFranchiseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FranchiseViewHolder, position: Int) {
        holder.bindWithView(franchiseItemList[position])
    }

    override fun getItemCount(): Int {
        return franchiseItemList.size
    }

    fun submitList(franchiseItemList: ArrayList<FranchiseItem>) {
        this.franchiseItemList = franchiseItemList
    }
}