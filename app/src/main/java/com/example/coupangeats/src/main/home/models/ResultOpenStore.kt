package com.example.coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultOpenStore(
    @SerializedName("storeIdx") val storeIdx: Int,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("deliveryFee") val deliveryFee: String,
    @SerializedName("coupon") val coupon: String,
    @SerializedName("storePhoto") val storePhoto: String,
    @SerializedName("distance") val distance: String
)
