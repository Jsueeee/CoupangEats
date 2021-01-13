package com.example.coupangeats.src.main.myPage.coupon.retrofit

import com.example.coupangeats.src.main.myPage.coupon.models.CouponViewResult
import retrofit2.Call
import retrofit2.http.GET

interface CouponRetrofitInterface {
    @GET("/coupons")
    fun getCouponResult(): Call<CouponViewResult>
}