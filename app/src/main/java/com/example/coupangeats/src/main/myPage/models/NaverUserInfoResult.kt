package com.example.coupangeats.src.main.myPage.models


import com.google.gson.annotations.SerializedName

data class NaverUserInfoResult(
    @SerializedName("message")
    val message: String,
    @SerializedName("response")
    val response: Response,
    @SerializedName("resultcode")
    val resultcode: String
)