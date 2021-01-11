package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class CouponInfo(
    @SerializedName("coupon")
    val coupon: String,
    @SerializedName("couponIdx")
    val couponIdx: Int
)