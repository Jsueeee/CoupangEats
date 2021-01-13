package com.example.coupangeats.src.main.myPage.coupon.recyclerview

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemCouponRecyclerviewBinding
import com.example.coupangeats.src.main.myPage.coupon.models.CouponList

class CouponRecyclerViewHolder(val binding: ItemCouponRecyclerviewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(couponList: CouponList) {
//        binding.couponTitle.setTextColor(Color.parseColor("#000000"))
        //      binding.couponTitle.setTextColor(ContextCompat.getColor(ApplicationClass.instance, R.color.black))

        binding.couponTitle.text = couponList.couponTitle
        if (couponList.expiredAt == "기간만료") {
            binding.expireDate.text = "기간만료"

        } else {
            binding.expireDate.text = couponList.expiredAt
            //색상 바꾸기
            binding.couponLayout.background = ContextCompat.getDrawable(ApplicationClass.instance, R.drawable.radius)
            binding.couponTitle.setTextColor(ContextCompat.getColor(
                ApplicationClass.instance,
                R.color.black
            ))
            binding.discount.setTextColor(Color.parseColor("#01AFFF"))
        }
        binding.discount.text = couponList.salePrice
        binding.minCost.text = couponList.minCost ?: ""
        binding.discount.text = couponList.salePrice
    }
}