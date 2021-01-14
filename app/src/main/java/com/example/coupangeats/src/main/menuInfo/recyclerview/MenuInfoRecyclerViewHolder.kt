package com.example.coupangeats.src.main.menuInfo.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemMenuInfoRecyclerviewBinding
import com.example.coupangeats.src.main.menuInfo.models.Optmenu

class MenuInfoRecyclerViewHolder(val binding: ItemMenuInfoRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(optmenu: Optmenu) {
        binding.menuOptName.text = optmenu.menuOptName
        binding.menuOptPrice.text = optmenu.menuOptPrice ?: ""
    }
}