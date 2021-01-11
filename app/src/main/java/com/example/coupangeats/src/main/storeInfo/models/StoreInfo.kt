package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class StoreInfo(
    @SerializedName("deliveryFee")
    val deliveryFee: String,
    @SerializedName("deliveryTime")
    val deliveryTime: String,
    @SerializedName("isCheetah")
    val isCheetah: String,
    @SerializedName("minOrderCost")
    val minOrderCost: String,
    @SerializedName("reviewCount")
    val reviewCount: Int,
    @SerializedName("storeName")
    val storeName: String,
    @SerializedName("storeStar")
    val storeStar: Double
)