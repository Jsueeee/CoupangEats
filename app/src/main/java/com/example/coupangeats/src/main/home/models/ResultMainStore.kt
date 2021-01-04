package com.example.coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultMainStore(
    @SerializedName("storeIdx") val storeIdx: Int,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("storeStar") val storeStar: Float,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("deliveryFee") val deliveryFee: String,
    @SerializedName("deliveryTime") val deliveryTime: String,
    @SerializedName("coupon") val coupon: String,
    @SerializedName("distance") val distance: String,
    @SerializedName("distance") val img_arr: ArrayList<String>
)
