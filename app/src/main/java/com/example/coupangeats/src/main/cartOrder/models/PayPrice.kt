package com.example.coupangeats.src.main.cartOrder.models


import com.google.gson.annotations.SerializedName

data class PayPrice(
    @SerializedName("couponPrice")
    val couponPrice: Any?,
    @SerializedName("deliveryFee")
    val deliveryFee: String,
    @SerializedName("orderPrice")
    val orderPrice: String,
    @SerializedName("TotalPrice")
    val totalPrice: String
)