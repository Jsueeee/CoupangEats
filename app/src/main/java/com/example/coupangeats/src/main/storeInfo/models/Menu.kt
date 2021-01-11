package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("isBestOrder")
    val isBestOrder: String,
    @SerializedName("isBestReview")
    val isBestReview: String,
    @SerializedName("menuDetail")
    val menuDetail: String?,
    @SerializedName("menuIdx")
    val menuIdx: Int,
    @SerializedName("menuPrice")
    val menuPrice: String,
    @SerializedName("menuThumbnail")
    val menuThumbnail: String?,
    @SerializedName("menuname")
    val menuname: String
)