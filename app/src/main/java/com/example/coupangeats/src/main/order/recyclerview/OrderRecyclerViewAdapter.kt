package com.example.coupangeats.src.main.order.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.databinding.ItemOrderRecyclerviewBinding
import com.example.coupangeats.src.main.order.models.OrderCancelRequest
import com.example.coupangeats.src.main.order.models.OrderListResponse
import com.example.coupangeats.src.main.order.models.OrderResult
import com.example.coupangeats.src.main.order.retrofit.OrderFragmentView
import com.example.coupangeats.src.main.order.retrofit.OrderService

class OrderRecyclerViewAdapter: RecyclerView.Adapter<OrderRecyclerViewHolder>(), OrderFragmentView  {

    private var orderResult = ArrayList<OrderResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderRecyclerViewHolder {
        return OrderRecyclerViewHolder(
            ItemOrderRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OrderRecyclerViewHolder, position: Int) {
        holder.bindWithView(orderResult[position])
        holder.binding.btnCancel.setOnClickListener {
            OrderService(this).onPostOrderCancel(OrderCancelRequest(orderResult[position].orderIdx))
            Log.d(TAG, "OrderRecyclerViewAdapter - onBindViewHolder() : order Idx : ${orderResult[position].orderIdx}")
        }
    }

    override fun getItemCount(): Int {
        return orderResult.size
    }

    fun submitList(orderResult: ArrayList<OrderResult>) {
        this.orderResult = orderResult
        notifyDataSetChanged()
    }

    override fun onGetOrderListSuccess(response: OrderListResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetOrderListFailure(message: String) {
        TODO("Not yet implemented")
    }
}