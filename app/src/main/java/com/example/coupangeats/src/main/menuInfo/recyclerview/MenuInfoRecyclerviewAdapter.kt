package com.example.coupangeats.src.main.menuInfo.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemMenuInfoRecyclerviewBinding
import com.example.coupangeats.src.main.menuInfo.MenuInfoActivity
import com.example.coupangeats.src.main.menuInfo.models.Optmenu

class MenuInfoRecyclerviewAdapter(val activity: MenuInfoActivity): RecyclerView.Adapter<MenuInfoRecyclerViewHolder>() {

    private var menuInfoList = ArrayList<Optmenu>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuInfoRecyclerViewHolder {
        return MenuInfoRecyclerViewHolder(
            ItemMenuInfoRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuInfoRecyclerViewHolder, position: Int) {
        holder.bindWithView(menuInfoList[position])

        holder.itemView.setOnClickListener {
            holder.click()
            activity.optionList.add(menuInfoList[position].menuOptIdx)
        }
    }

    override fun getItemCount(): Int {
        return menuInfoList.size
    }

    fun submitList(menuInfoList: ArrayList<Optmenu>) {
        this.menuInfoList = menuInfoList
        notifyDataSetChanged()
    }
}