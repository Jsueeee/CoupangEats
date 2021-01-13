package com.example.coupangeats.src.main.DetailListNewStore.models


import com.google.gson.annotations.SerializedName

data class DetailListNewStoreResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Result>
)