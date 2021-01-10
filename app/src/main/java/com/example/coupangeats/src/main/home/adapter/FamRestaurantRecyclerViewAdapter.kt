package com.example.coupangeats.src.main.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.home.itemInterface.FamRestaurantRecyclerViewInterface
import com.example.coupangeats.src.main.home.viewholder.FamRestaurantViewHolder
import com.example.coupangeats.src.main.home.models.MainStore

class FamRestaurantRecyclerViewAdapter(famRestaurantRecyclerViewInterface: FamRestaurantRecyclerViewInterface): RecyclerView.Adapter<FamRestaurantViewHolder>() {

    private var famRestaurantItemList = ArrayList<MainStore>()

    private var famRestaurantRecyclerViewInterface: FamRestaurantRecyclerViewInterface? = null

    init {
        this.famRestaurantRecyclerViewInterface = famRestaurantRecyclerViewInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamRestaurantViewHolder {
        return FamRestaurantViewHolder(
            ItemHomeFamousRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            famRestaurantRecyclerViewInterface!!
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