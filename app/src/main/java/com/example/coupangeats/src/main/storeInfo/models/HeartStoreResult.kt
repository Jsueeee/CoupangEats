package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class HeartStoreResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: Result
)