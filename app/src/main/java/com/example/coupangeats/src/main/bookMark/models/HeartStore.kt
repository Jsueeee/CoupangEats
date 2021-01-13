package com.example.coupangeats.src.main.bookMark.models


import com.google.gson.annotations.SerializedName

data class HeartStore(
    @SerializedName("coupon")
    val coupon: Any?,
    @SerializedName("deliveryFee")
    val deliveryFee: String,
    @SerializedName("deliveryTime")
    val deliveryTime: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("isCheetah")
    val isCheetah: String,
    @SerializedName("reviewCount")
    val reviewCount: Int,
    @SerializedName("storeIdx")
    val storeIdx: Int,
    @SerializedName("storeName")
    val storeName: String,
    @SerializedName("storePhoto")
    val storePhoto: String,
    @SerializedName("storeStar")
    val storeStar: Any?
)