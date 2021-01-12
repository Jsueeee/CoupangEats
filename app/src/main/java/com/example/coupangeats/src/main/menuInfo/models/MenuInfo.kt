package com.example.coupangeats.src.main.menuInfo.models


import com.google.gson.annotations.SerializedName

data class MenuInfo(
    @SerializedName("menuDetail")
    val menuDetail: String,
    @SerializedName("menuName")
    val menuName: String,
    @SerializedName("menuPrice")
    val menuPrice: String
)