package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("storeIdx")
    val storeIdx: Int,
    @SerializedName("userIdx")
    val userIdx: Int
)