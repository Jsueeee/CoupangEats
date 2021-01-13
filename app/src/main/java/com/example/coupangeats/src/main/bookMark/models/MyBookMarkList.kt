package com.example.coupangeats.src.main.bookMark.models


import com.google.gson.annotations.SerializedName

data class MyBookMarkList(
    @SerializedName("code")
    val code: Int,
    @SerializedName("heartCount")
    val heartCount: Int,
    @SerializedName("heartStore")
    val heartStore: List<HeartStore>,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String
)