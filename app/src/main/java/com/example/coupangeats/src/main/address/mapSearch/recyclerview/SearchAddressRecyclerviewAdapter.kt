package com.example.coupangeats.src.main.address.mapSearch.recyclerview

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.databinding.ItemSearchAddressRecyclerviewBinding
import com.example.coupangeats.src.main.address.mapDetail.MapDetailActivity
import com.example.coupangeats.src.main.address.models.SearchRecyclerViewResult

class SearchAddressRecyclerviewAdapter(val context: Context): RecyclerView.Adapter<SearchAddressViewHolder>() {

    private var searchResultItemList = ArrayList<SearchRecyclerViewResult>()

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    lateinit var address: String
    lateinit var buildingName: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAddressViewHolder {
        return SearchAddressViewHolder(
            ItemSearchAddressRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchAddressViewHolder, position: Int) {
        holder.bindWithView(searchResultItemList[position])

        holder.itemView.setOnClickListener {

            buildingName = searchResultItemList[position].placeName

            if(searchResultItemList[position].roadAddressName == ""){
                address = searchResultItemList[position].addressName
            }else{
                address = searchResultItemList[position].roadAddressName
            }

            val intent = Intent(context, MapDetailActivity::class.java)
            intent.putExtra("latitude", latitude)
            intent.putExtra("longitude", longitude)
            intent.putExtra("address", address)
            intent.putExtra("buildingName", buildingName)
            startActivity(context, intent, null)
        }
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