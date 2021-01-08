package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("coords")
    val coords: Coords,
    @SerializedName("name")
    val name: String
)