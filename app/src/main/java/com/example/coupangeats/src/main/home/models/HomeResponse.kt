package com.example.coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: List<ResultHome>
)
