package com.example.coupangeats.src.main.myPage.coupon.models


import com.google.gson.annotations.SerializedName

data class CouponViewResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<CouponList>
)