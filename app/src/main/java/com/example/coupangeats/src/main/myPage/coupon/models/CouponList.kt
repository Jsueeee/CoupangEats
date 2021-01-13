package com.example.coupangeats.src.main.myPage.coupon.models


import com.google.gson.annotations.SerializedName

data class CouponList(
    @SerializedName("couponIdx")
    val couponIdx: Int,
    @SerializedName("couponTitle")
    val couponTitle: String,
    @SerializedName("expiredAt")
    val expiredAt: String,
    @SerializedName("minCost")
    val minCost: String?,
    @SerializedName("salePrice")
    val salePrice: String
)