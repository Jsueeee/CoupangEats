package com.example.coupangeats.src.main.detailListFranchise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.detailListFranchise.models.Result

class DetailFranchiseRecyclerViewAdapter: RecyclerView.Adapter<DetailFranchiseRecyclerViewHolder>() {

    private var famRestaurantItemList = ArrayList<Result>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailFranchiseRecyclerViewHolder {
        return DetailFranchiseRecyclerViewHolder(
            ItemHomeFamousRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun onBindViewHolder(holder: DetailFranchiseRecyclerViewHolder, position: Int) {
        holder.bindWithView(famRestaurantItemList[position])
    }

    override fun getItemCount(): Int {
        return famRestaurantItemList.size
    }

    fun submitList(famRestaurantItemList: ArrayList<Result>){
        this.famRestaurantItemList = famRestaurantItemList
        notifyDataSetChanged()
    }
}