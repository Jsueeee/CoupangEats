package com.example.coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultFranchise(
    @SerializedName("storeIdx") val storeIdx: Int,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("storeStar") val storeStar: Float,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("deliveryFee") val deliveryFee: String,
    @SerializedName("coupon") val coupon: String,
    @SerializedName("storePhoto") val storePhoto: String,
    @SerializedName("distance") val distance: String
)
