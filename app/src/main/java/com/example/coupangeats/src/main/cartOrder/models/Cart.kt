package com.example.coupangeats.src.main.cartOrder.models


import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("menuIdx")
    val menuIdx: Int,
    @SerializedName("menuName")
    val menuName: String,
    @SerializedName("option")
    val option: List<String>,
    @SerializedName("price")
    val price: String,
    @SerializedName("quantity")
    val quantity: Int
)