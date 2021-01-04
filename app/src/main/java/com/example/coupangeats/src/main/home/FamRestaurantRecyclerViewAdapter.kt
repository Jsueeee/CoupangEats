package com.example.coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.home.models.MainStore

class FamRestaurantRecyclerViewAdapter: RecyclerView.Adapter<FamRestaurantViewHolder>() {

    private var famRestaurantItemList = ArrayList<MainStore>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamRestaurantViewHolder {
        return FamRestaurantViewHolder(
            ItemHomeFamousRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FamRestaurantViewHolder, position: Int) {
        holder.bindWithView(famRestaurantItemList[position])
    }

    override fun getItemCount(): Int {
        return famRestaurantItemList.size
    }

    fun submitList(famRestaurantItemList: ArrayList<MainStore>){
        this.famRestaurantItemList = famRestaurantItemList
        notifyDataSetChanged()
    }

}