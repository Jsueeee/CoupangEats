package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class CouponResult(
    @SerializedName("couponIdx")
    val couponIdx: Int,
    @SerializedName("userIdx")
    val userIdx: Int
)