package com.example.coupangeats.src.main.cartOrder.models


import com.google.gson.annotations.SerializedName

data class Coupon(
    @SerializedName("couponCount")
    val couponCount: Int,
    @SerializedName("couponPrice")
    val couponPrice: Any?
)