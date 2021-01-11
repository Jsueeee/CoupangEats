package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class StoreInfoResult(
    @SerializedName("categoryMenu")
    val categoryMenu: ArrayList<CategoryMenu>,
    @SerializedName("code")
    val code: Int,
    @SerializedName("couponInfo")
    val couponInfo: CouponInfo,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("photoReview")
    val photoReview: ArrayList<PhotoReview>,
    @SerializedName("storeInfo")
    val storeInfo: ArrayList<StoreInfo>,
    @SerializedName("storePhoto")
    val storePhoto: ArrayList<String>
)