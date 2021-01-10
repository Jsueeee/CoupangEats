package com.example.coupangeats.src.main.address.mapSearch.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.databinding.ItemSearchAddressRecyclerviewBinding
import com.example.coupangeats.src.main.address.models.SearchRecyclerViewResult

class SearchAddressRecyclerviewAdapter: RecyclerView.Adapter<SearchAddressViewHolder>() {

    private var searchResultItemList = ArrayList<SearchRecyclerViewResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAddressViewHolder {
        return SearchAddressViewHolder(
            ItemSearchAddressRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchAddressViewHolder, position: Int) {
        holder.bindWithView(searchResultItemList[position])
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "map / SearchAddressRecyclerviewAdapter - getItemCount() : 사이즈 : ${searchResultItemList.size}")
        return searchResultItemList.size
    }

    fun submitList(searchResultItemList: ArrayList<SearchRecyclerViewResult>){
        this.searchResultItemList = searchResultItemList
        Log.d(TAG, "map / SearchAddressRecyclerviewAdapter - submitList() : 리사이클러뷰어댑터 $searchResultItemList")
        notifyDataSetChanged()
    }
}