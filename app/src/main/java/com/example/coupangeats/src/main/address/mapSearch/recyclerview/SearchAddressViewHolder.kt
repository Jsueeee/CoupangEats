package com.example.coupangeats.src.main.address.mapSearch.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.databinding.ItemSearchAddressRecyclerviewBinding
import com.example.coupangeats.src.main.address.models.SearchRecyclerViewResult

class SearchAddressViewHolder(val binding: ItemSearchAddressRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(searchAddressResultItem: SearchRecyclerViewResult) {
        binding.searchItemTitle.text = searchAddressResultItem.placeName

        if(searchAddressResultItem.roadAddressName == ""){
            binding.searchItemSubtitle.text = searchAddressResultItem.addressName
            binding.imgLogoAddress.setImageResource(R.drawable.ic_address_name)
        }else{
            binding.searchItemSubtitle.text = searchAddressResultItem.roadAddressName
            binding.imgLogoAddress.setImageResource(R.drawable.ic_address_road)
        }

    }
}