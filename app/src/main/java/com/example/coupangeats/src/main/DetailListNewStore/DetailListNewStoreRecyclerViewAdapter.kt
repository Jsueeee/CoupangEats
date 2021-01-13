package com.example.coupangeats.src.main.DetailListNewStore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.DetailListNewStore.models.Result

class DetailListNewStoreRecyclerViewAdapter : RecyclerView.Adapter<DetailListNewStoreRecyclerViewHolder>() {

    private var franchiseItemList = ArrayList<Result>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailListNewStoreRecyclerViewHolder {
        return DetailListNewStoreRecyclerViewHolder(
            ItemHomeFamousRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DetailListNewStoreRecyclerViewHolder, position: Int) {
        holder.bindWithView(franchiseItemList[position])
    }

    override fun getItemCount(): Int {
        return franchiseItemList.size
    }

    fun submitList(famRestaurantItemList: ArrayList<Result>){
        this.franchiseItemList = famRestaurantItemList
        notifyDataSetChanged()
    }
}