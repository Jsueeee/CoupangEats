package com.example.coupangeats.src.main.order.models


import com.google.gson.annotations.SerializedName

data class OrderMenu(
    @SerializedName("menuIdx")
    val menuIdx: Int,
    @SerializedName("menuName")
    val menuName: String,
    @SerializedName("optionNameList")
    val optionNameList: List<String>,
    @SerializedName("quantity")
    val quantity: Int
)