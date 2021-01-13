package com.example.coupangeats.src.main.detailList.models


import com.google.gson.annotations.SerializedName

data class DetailListResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Result>
)