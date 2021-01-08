package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class Coords(
    @SerializedName("center")
    val center: Center
)