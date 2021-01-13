package com.example.coupangeats.src.main.myPage.coupon.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemCouponRecyclerviewBinding
import com.example.coupangeats.src.main.myPage.coupon.models.CouponList

class CouponRecyclerViewAdapter: RecyclerView.Adapter<CouponRecyclerViewHolder>() {

    private var couponList = ArrayList<CouponList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponRecyclerViewHolder {
        return CouponRecyclerViewHolder(
            ItemCouponRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CouponRecyclerViewHolder, position: Int) {
        holder.bindWithView(couponList[position])
    }

    override fun getItemCount(): Int {
        return couponList.size
    }

    fun submitList(couponList: ArrayList<CouponList>) {
        this.couponList = couponList
        notifyDataSetChanged()
    }
}