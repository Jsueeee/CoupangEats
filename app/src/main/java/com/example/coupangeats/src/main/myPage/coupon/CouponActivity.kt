package com.example.coupangeats.src.main.myPage.coupon

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityCouponBinding
import com.example.coupangeats.src.main.myPage.coupon.models.CouponList
import com.example.coupangeats.src.main.myPage.coupon.models.CouponViewResult
import com.example.coupangeats.src.main.myPage.coupon.recyclerview.CouponRecyclerViewAdapter
import com.example.coupangeats.src.main.myPage.coupon.retrofit.CouponService
import com.example.coupangeats.src.main.myPage.coupon.retrofit.CouponView

class CouponActivity:BaseActivity<ActivityCouponBinding>(ActivityCouponBinding::inflate), CouponView {

    private var couponList = ArrayList<CouponList>()
    private lateinit var couponRecyclerViewAdapter: CouponRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CouponService(this).getCouponResult()

        couponRecyclerViewAdapter = CouponRecyclerViewAdapter()
        binding.recyclerViewCoupon.apply {
            adapter = couponRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun onGetCouponResultSuccess(response: CouponViewResult) {
        response.result.forEach {
            couponList.add(it)
        }
        couponRecyclerViewAdapter.submitList(couponList)
    }

    override fun onGetCouponResultFailure(message: String) {

    }
}


