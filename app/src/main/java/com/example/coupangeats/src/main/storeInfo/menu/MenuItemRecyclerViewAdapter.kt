package com.example.coupangeats.src.main.storeInfo.menu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemMenuRecyclerviewSubBinding
import com.example.coupangeats.src.main.menuInfo.MenuInfoActivity
import com.example.coupangeats.src.main.storeInfo.models.Menu

class MenuItemRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<MenuItemRecyclerViewHolder>(){

    private var menuItemList = ArrayList<Menu>()
    private var storeIdx = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemRecyclerViewHolder {
        return MenuItemRecyclerViewHolder(
            ItemMenuRecyclerviewSubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuItemRecyclerViewHolder, position: Int) {
        holder.bindWithView(menuItemList[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, MenuInfoActivity::class.java)
            intent.putExtra("menuIdx", menuItemList[position].menuIdx)
            intent.putExtra("storeIdx", storeIdx)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return menuItemList.size
    }

    fun submitList(menuItemList: ArrayList<Menu>, storeIdx: Int){
        this.menuItemList = menuItemList
        this.storeIdx = storeIdx
        notifyDataSetChanged()
    }
}