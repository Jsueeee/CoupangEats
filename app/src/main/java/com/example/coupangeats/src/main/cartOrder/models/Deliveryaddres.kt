package com.example.coupangeats.src.main.cartOrder.models


import com.google.gson.annotations.SerializedName

data class Deliveryaddres(
    @SerializedName("deliveryAddress")
    val deliveryAddress: String,
    @SerializedName("deliveryBuildingName")
    val deliveryBuildingName: String
)