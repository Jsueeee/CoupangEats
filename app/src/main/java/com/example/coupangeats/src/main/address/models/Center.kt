package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class Center(
    @SerializedName("crs")
    val crs: String,
    @SerializedName("x")
    val x: Double,
    @SerializedName("y")
    val y: Double
)