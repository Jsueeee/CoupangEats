package com.example.coupangeats.src.main.cartOrder.models


import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("paymentIdx")
    val paymentIdx: Int,
    @SerializedName("paymentMethod")
    val paymentMethod: String
)