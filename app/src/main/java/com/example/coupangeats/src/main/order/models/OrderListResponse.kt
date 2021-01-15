package com.example.coupangeats.src.main.order.models


import com.google.gson.annotations.SerializedName

data class OrderListResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<OrderResult>
)