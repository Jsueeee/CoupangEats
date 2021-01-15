package com.example.coupangeats.src.main.order.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemOrderRecyclerviewBinding
import com.example.coupangeats.src.main.order.models.OrderResult

class OrderRecyclerViewAdapter: RecyclerView.Adapter<OrderRecyclerViewHolder>() {

    private var orderResult = ArrayList<OrderResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderRecyclerViewHolder {
        return OrderRecyclerViewHolder(
            ItemOrderRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OrderRecyclerViewHolder, position: Int) {
        holder.bindWithView(orderResult[position])
    }

    override fun getItemCount(): Int {
        return orderResult.size
    }

    fun submitList(orderResult: ArrayList<OrderResult>) {
        this.orderResult = orderResult
        notifyDataSetChanged()
    }
}