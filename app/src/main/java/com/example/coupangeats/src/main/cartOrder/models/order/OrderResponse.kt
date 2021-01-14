package com.example.coupangeats.src.main.cartOrder.models.order


import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: OrderIdxResult
)