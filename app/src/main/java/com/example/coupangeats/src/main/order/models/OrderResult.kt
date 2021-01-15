package com.example.coupangeats.src.main.order.models


import com.google.gson.annotations.SerializedName

data class OrderResult(
    @SerializedName("menuList")
    val menuList: List<List<OrderMenu>>,
    @SerializedName("orderIdx")
    val orderIdx: Int,
    @SerializedName("orderPrice")
    val orderPrice: String,
    @SerializedName("orderState")
    val orderState: Int,
    @SerializedName("orderStateName")
    val orderStateName: String,
    @SerializedName("orderTime")
    val orderTime: String,
    @SerializedName("storeIdx")
    val storeIdx: Int,
    @SerializedName("storeName")
    val storeName: String,
    @SerializedName("storePhoto")
    val storePhoto: String
)