package com.example.coupangeats.src.main.myPage.coupon.retrofit

import com.example.coupangeats.src.main.myPage.coupon.models.CouponViewResult

interface CouponView {
    fun onGetCouponResultSuccess(response: CouponViewResult)
    fun onGetCouponResultFailure(message: String)
}