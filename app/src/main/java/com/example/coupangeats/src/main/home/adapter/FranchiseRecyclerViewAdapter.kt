package com.example.coupangeats.src.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeFranchiseBinding
import com.example.coupangeats.src.main.home.viewholder.FranchiseViewHolder
import com.example.coupangeats.src.main.home.models.Franchise

class FranchiseRecyclerViewAdapter : RecyclerView.Adapter<FranchiseViewHolder>() {

    private var franchiseItemList = ArrayList<Franchise>()

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

    fun submitList(franchiseItemList: ArrayList<Franchise>) {
        this.franchiseItemList = franchiseItemList
        notifyDataSetChanged()
    }
}