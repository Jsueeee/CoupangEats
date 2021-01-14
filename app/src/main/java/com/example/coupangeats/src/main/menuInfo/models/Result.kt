package com.example.coupangeats.src.main.menuInfo.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("menuIdx")
    val menuIdx: Int,
    @SerializedName("option")
    val option: List<Int>,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("storeIdx")
    val storeIdx: Int,
    @SerializedName("userIdx")
    val userIdx: Int
)